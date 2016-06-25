package in.milcom;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Authenticator authenticator;

    @Autowired
    public UserController(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody final UserLogin login)
        throws AuthenticationException {
        
        return authenticator.authenticate(login);
    }
}