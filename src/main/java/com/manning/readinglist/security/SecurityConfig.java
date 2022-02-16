package com.manning.readinglist.security;

import com.manning.readinglist.dao.ReaderRepository;
import com.manning.readinglist.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * @author jrl
 * @date Create in 17:58 2022-2-15
 */

/**
 * knowledge point:
 *     1.作为security，这俩注解就是组合是用的，Configuration是spring的，用于说明这是配置类
 *       EnableWebSecurity是spring security的，用于说明这是spring security的注解.
 *     2.通过继承WebSecurityConfigurerAdapter，重写configure方法就覆盖了springboot的安全自动配置，
 *       这样就可以自定义我们需要的安全配置。
 * @author 小虫子的小日常
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ReaderRepository readerRepository;

    /**
     * 配置权限
     *
     * @param
     * @return
     * @date 2022-2-15
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // todo / 和 /** 有什么区别
                // 访问x路径的请求需要符合xx角色才可以
                .antMatchers("/").access("hasRole('READER')")
                // 访问x路径的请求被允许
                .antMatchers("/**").permitAll()
            .and()
            .formLogin()
                // 登录路径（controller的那个）
                .loginPage("/login")
                // 登陆失败页
                .failureUrl("/login?error=true");
    }

    /**
     * 配置如何认证：
     * 实现UserDetailsService类，spring security就会自动执行该方法来进行认证
     * @param
     * @return
     * @date 2022-2-15
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(new UserDetailsService() {
                @Override
                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    // todo 这样就没问题，那就是jpa的使用有问题
                    return new Reader("a","b","c");
                }
            });
    }
}
