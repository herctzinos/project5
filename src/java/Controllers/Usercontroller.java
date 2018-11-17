package Controllers;

import UserDAO.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Usercontroller {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "index")
    public String login(ModelMap model) {
        User user = new User();
        user.setName("Username");
        user.setPassword("password");
        model.addAttribute("userLogin", user);
        return "index";
    }

    @RequestMapping(value = "adduser")
    public String add(ModelMap model, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        User u = new User();
        u.setName(name);
        u.setPassword(password);
        if (!userDao.finder(name)){
        userDao.adduser(u);
        return "adduser";
        }
        return "unauthorized";
    }

    @RequestMapping(value = "checkuser")
    public String check(ModelMap model, @RequestParam(value = "name") String name, @RequestParam(value = "password3") String password3) {
        User u = new User();
        if (userDao.finder(name)) {
            if (userDao.list(name, password3)) {
                return "authorized";
            }
        }
        return "unauthorized";
    }

}
