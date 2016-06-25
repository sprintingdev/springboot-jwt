package in.milcom;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class PlainTextAuthenticator implements Authenticator {
	
	private final Map<String, List<String>> userDb = new HashMap<>();

	public PlainTextAuthenticator() {
		userDb.put("viv", Arrays.asList("user"));
        userDb.put("root", Arrays.asList("user", "admin"));
	}

	public LoginResponse authenticate(UserLogin login) throws AuthenticationException {
		if (login.getName() == null || !userDb.containsKey(login.getName())) {
            throw new AuthenticationException("Invalid login");
        } else {
        	return new LoginResponse(Jwts.builder().setSubject(login.getName())
            .claim("roles", userDb.get(login.getName())).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());	
        }
	}
}