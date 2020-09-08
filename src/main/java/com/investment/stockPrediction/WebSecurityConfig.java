package com.investment.stockPrediction;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication()
		  .withUser("user").password("{noop}password").roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http 
			.csrf() 
			.disable()
			.authorizeRequests()
			//.antMatchers("/**").permitAll()
	        .antMatchers("/upload**").hasRole("USER")
	        .antMatchers("/getUploadData**").hasRole("USER")
	        .antMatchers("/login**").hasRole("USER")
	        .antMatchers("/addStockRecord**").permitAll()
	        .antMatchers("/getStockRecords**").permitAll()
	        .and()
	        .formLogin();

	}
}

