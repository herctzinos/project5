package UserDAO;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import mapper.UserMapper;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class UserDAOimpl implements UserDAO {

    private DataSource dataSource;

    public UserDAOimpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean list(String name, String password) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        User u = new User();

        u = (User) jdbcTemplate.queryForObject("SELECT * FROM user WHERE name=?", new Object[]{name}, new UserMapper());
        return BCrypt.checkpw(password, u.getHash());
    }

    @Override
    public int adduser(User u) {

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("user");
        Map<String, Object> parameters = new HashMap<String, Object>();
        String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());

        parameters.put("name", u.getName());
        parameters.put("hash", hashed);

        return simpleJdbcInsert.execute(parameters);

    }

    @Override
    public boolean finder(String username) {
        try {
            String sql = "SELECT id FROM user WHERE name ='" + username + "'";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            Long id = jdbcTemplate.queryForObject(sql, Long.class);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;

    }
}
