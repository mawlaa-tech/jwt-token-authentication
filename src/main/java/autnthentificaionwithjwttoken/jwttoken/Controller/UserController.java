package autnthentificaionwithjwttoken.jwttoken.Controller;

import autnthentificaionwithjwttoken.jwttoken.entity.User;
import autnthentificaionwithjwttoken.jwttoken.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

   @Autowired
    private UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @PostConstruct
    public void initRoleAndUser(){userService.inititRoleAndUser();}

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return  userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

}
