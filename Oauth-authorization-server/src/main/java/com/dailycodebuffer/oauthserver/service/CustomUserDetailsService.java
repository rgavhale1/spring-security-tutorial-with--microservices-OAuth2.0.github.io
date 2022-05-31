package com.dailycodebuffer.oauthserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.oauthserver.entity.Role;
import com.dailycodebuffer.oauthserver.entity.User;
import com.dailycodebuffer.oauthserver.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*
		 * User us = new User(1, "anurag", passwordEncoder().encode("anu"), "admin",
		 * "anurag@gmail.com", Arrays.asList(Role.builder().roleName("admin").build()));
		 * userRepository.save(us);
		 */

		User user = userRepository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found exception");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,
				true, true, true, getAuthorities(user.getRole()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		roles.stream().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName())));

		return grantedAuthorities;
	}

}
