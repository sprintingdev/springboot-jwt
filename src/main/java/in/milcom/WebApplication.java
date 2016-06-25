package in.milcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.embedded.FilterRegistrationBean;


@SpringBootApplication
public class WebApplication {

	@Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }

    @Bean
    public Authenticator authenticator() {
    	return new PlainTextAuthenticator();
    }

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
