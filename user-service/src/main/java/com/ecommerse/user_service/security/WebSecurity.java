package com.ecommerse.user_service.security;

import com.ecommerse.user_service.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurity {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf( (csfr) -> csfr.disable());

        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers(new AntPathRequestMatcher("/user-service/actuator/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user-service/h2-console/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user-service/users", "POST")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user-service/welcome")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user-service/health_check")).permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    }

}
