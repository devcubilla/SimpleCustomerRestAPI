package com.edge.restapi.security;

import com.edge.restapi.paths.ApiPaths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	private static final String[] AUTH_WHITELIST = {ApiPaths.HELLO};
	@Value("${auth.user}")
	String auth_user;

	@Value("${auth.role.basic}")
	String auth_role_basic;

	@Value("${auth.user.pass}")
	String auth_user_pass;

	@Value("${auth.role.more}")
	String auth_role_more;
	@Value("${auth.admin}")
	String auth_admin;

	@Value("${auth.admin.pass}")
	String auth_admin_pass;

	// Secure endpoints with Http-Basic-Auth
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests( auth -> auth
	                    .requestMatchers(AUTH_WHITELIST).permitAll()
	                    .requestMatchers(HttpMethod.GET, ApiPaths.ABOUT_CUSTOMER).hasRole(auth_role_basic)
	                    .requestMatchers(HttpMethod.POST, ApiPaths.ADD_CUSTOMER).hasRole(auth_role_more)
	                    .requestMatchers(HttpMethod.PUT, ApiPaths.UPDATE_CUSTOMER).hasRole(auth_role_more)
	                    .requestMatchers(HttpMethod.DELETE, ApiPaths.DELETE_CUSTOMER).hasRole(auth_role_more)
	                    .anyRequest().authenticated()
	            )
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().build();
		
	}
	// Create 2 user + pass
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername(auth_admin).password(passwordEncoder().encode(auth_admin_pass)).roles(auth_role_more).build());
		manager.createUser(User.withUsername(auth_user).password(passwordEncoder().encode(auth_user_pass)).roles(auth_role_basic).build());
		return manager;
	}
	// PassEncoder
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}