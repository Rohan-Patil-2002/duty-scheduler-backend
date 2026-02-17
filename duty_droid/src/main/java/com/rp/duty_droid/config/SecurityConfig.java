package com.rp.duty_droid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) //Disable CSRF completely
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()   //Allow ALL requests
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
