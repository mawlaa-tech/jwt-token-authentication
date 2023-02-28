package autnthentificaionwithjwttoken.jwttoken.Controller;

import autnthentificaionwithjwttoken.jwttoken.entity.JwtRequest;
import autnthentificaionwithjwttoken.jwttoken.entity.JwtResponse;
import autnthentificaionwithjwttoken.jwttoken.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{

        return jwtService.createJwtToken(jwtRequest);
    }
}
