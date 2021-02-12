package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {


    @Bean
    public UserDetailsManager userDetailsService(DataSource dataSource) {
        String selectByUserNameQuery = "select username,password,enabled from users_new where username = ?";
        String selectAuthorityByUserNameQuery = "select username,authority from authorities_new where username = ?";
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(selectByUserNameQuery);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(selectAuthorityByUserNameQuery);
        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
