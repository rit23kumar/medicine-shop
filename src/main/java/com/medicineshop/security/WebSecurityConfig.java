import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http
        //     .authorizeRequests()
        //     .anyRequest().authenticated();

        http
        .csrf().disable() // Disable CSRF for testing APIs with POST/PUT/DELETE
        .authorizeRequests()
        .anyRequest().permitAll();
    }
}