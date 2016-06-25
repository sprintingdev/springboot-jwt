package in.milcom;

interface Authenticator {
	public LoginResponse authenticate(UserLogin userLogin) throws AuthenticationException;
}