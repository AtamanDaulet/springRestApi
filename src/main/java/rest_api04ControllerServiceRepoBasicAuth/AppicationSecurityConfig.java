package rest_api04ControllerServiceRepoBasicAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
	Admin ==> GET(Read), PUT + POST + PATCH + DELETE(Write)
	Student ==> GET(Read)
*/


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)//If you want to enable @PreAuthorize in any class use this.
public class AppicationSecurityConfig extends WebSecurityConfigurerAdapter{

	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public AppicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers("/", "index", "/css/*","/js/*" ).permitAll()
			//.antMatchers("/**").hasRole(ApplicationUserRoles.ADMIN.name())
			//If you type that just ADMIN will be able to use all methods
            //If you do not type that all roles will be able to use all methods 
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic(); //Basic-Authentication: Uses username and password for every request
		
		/*.antMatcher("/**")  
        .authorizeRequests()  
        .antMatchers("/").permitAll()  
        .anyRequest().authenticated()
        .and().formLogin()
        .and()  
        .httpBasic();*/
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails student= User
				.builder()
				.username("dake")
				.password(passwordEncoder.encode("password123"))				
				//.roles(ApplicationUserRoles.STUDENT.name())
				.authorities(ApplicationUserRoles.STUDENT.getGrantedAuthorities())
				.build();
		
		UserDetails admin = User.
				builder().
				username("admin").
				password(passwordEncoder.encode("nimda")).
				//roles(ApplicationUserRoles.ADMIN.name()).
				authorities(ApplicationUserRoles.ADMIN.getGrantedAuthorities()).
				build();

		return new InMemoryUserDetailsManager (student, admin);
	}
	
	

}
