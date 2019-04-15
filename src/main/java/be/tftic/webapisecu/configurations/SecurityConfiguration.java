package be.tftic.webapisecu.configurations;

import be.tftic.webapisecu.dal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService service;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.inMemoryAuthentication()
            .withUser("amaury").password(encoder().encode("1234")).roles("USER", "ADMIN")
            .and()
            .withUser("toto").password(encoder().encode("1234")).roles("USER");*/
        auth.userDetailsService(service).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.csrf()
           .disable()
           .httpBasic()
           .and()
           .authorizeRequests()
           .antMatchers("/**").authenticated()
           .antMatchers("/h2").permitAll()
           .antMatchers(HttpMethod.GET, "/item").hasRole("USER")
           .and()
           .sessionManagement()
           .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //seulement pour h2
        http.headers().frameOptions().disable();

    }


}

