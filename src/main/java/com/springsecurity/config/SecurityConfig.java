package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((authorize) -> {
			authorize.requestMatchers("api/v1/**").permitAll();
			authorize.anyRequest().authenticated();

		}).httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		UserDetails john = User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER")
				.build();

		UserDetails sam = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(john, sam);
	}

}
