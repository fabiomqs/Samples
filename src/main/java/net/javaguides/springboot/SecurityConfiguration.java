package net.javaguides.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication()
        //        .withUser("blah")
        //        .password("blah")
        //        .roles("USER")
        //        .and()
        //        .withUser("foo")
        //        .password("foo")
        //        .roles("ADMIN");

        auth.jdbcAuthentication();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests() //deve ir da permissão mais restritiva para a mesmo restritiva, então a permitAll deve ser a última
        //        .antMatchers("/admin").hasRole("ADMIN")
        //        .antMatchers("/user").hasAnyRole("USER", "ADMIN")
        //        .antMatchers("/").permitAll() //permite acesso às apis públicas e também se for o caso a arquivos estáticos, como js, css, imagens e etc
        //        .and().formLogin();
    }
}
