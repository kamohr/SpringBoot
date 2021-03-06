package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/api/**").authorizeRequests().antMatchers(HttpMethod.GET, "/**")
				.access("#oauth2.hasScope('read')").antMatchers(HttpMethod.POST, "/**")
				.access("#oauth2.hasScope('write')").antMatchers(HttpMethod.PUT, "/**")
				.access("#oauth2.hasScope('write')").antMatchers(HttpMethod.DELETE, "/**")
				.access("#oauth2.hasScope('write')");
	}
}
