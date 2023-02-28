package autnthentificaionwithjwttoken.jwttoken.service;

import autnthentificaionwithjwttoken.jwttoken.dao.RoleDao;
import autnthentificaionwithjwttoken.jwttoken.dao.UserDao;
import autnthentificaionwithjwttoken.jwttoken.entity.Role;
import autnthentificaionwithjwttoken.jwttoken.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    public void inititRoleAndUser(){

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role newly created ");
        roleDao.save(userRole);

        User adminUser = new User();

        adminUser.setUserName("admin123");
        adminUser.setUserPassWord(getEncodedPassword("admin123"));
        adminUser.setUserFirstName("Salim");
        adminUser.setUserLastName("Drame");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        /*User user = new User();

        user.setUserName("user123");
        user.setUserPassWord("user123");
        user.setUserFirstName(":Mawlaa");
        user.setUserLastName("Drame");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);*/

    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassWord(getEncodedPassword(user.getUserPassWord()));

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
