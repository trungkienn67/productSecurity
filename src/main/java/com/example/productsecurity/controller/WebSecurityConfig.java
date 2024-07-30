package com.example.productsecurity.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity ) throws Exception {
        return httpSecurity.authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/maintenances/list").permitAll();
                    registry.requestMatchers("/maintenances/showFormForAdd").hasRole("ADMIN");
                    registry.requestMatchers("/maintenances/showFormForUpdate").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("kien")
                .password("$2a$12$gJrnAsZLaLUI3FpEKtPeLuxV0BWbeEPGRbRBNzD4BQQP2j2nWgEkC")
                .roles("USER")
                .build();
        UserDetails adminUser = User.builder()
                .username("admin")
                .password("$2a$12$PCh7cp9r7tRUmWPzifAa6.gfMfOhGxQyajZTBxBUfHQV/N89zOtT6")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }
}
