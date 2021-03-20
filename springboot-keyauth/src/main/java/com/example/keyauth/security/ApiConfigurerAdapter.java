package com.example.keyauth.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class ApiConfigurerAdapter extends WebSecurityConfigurerAdapter {
	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApiFilter filter = new ApiFilter("Api-key");
        filter.setAuthenticationManager(new ApiAuthenticationManager("This is My Secrates"));

        http.csrf().
                disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and()
                    .addFilter(filter)
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated();
    }
}
