package UserDAO;

import model.User;

public interface UserDAO {

    public int adduser(User u);

    public boolean list(String username, String password);

    public boolean finder(String username);

}
