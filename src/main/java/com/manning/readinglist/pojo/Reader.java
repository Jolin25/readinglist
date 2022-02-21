package com.manning.readinglist.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;


/**
 * knowledge point:
 * 1.该类用于使用JPA方式来进行安全认证：
 *   需要实现spring security提供的UserDetails接口，用于表示这个类是spring security的用户
 * 2.JPA
 *   Entity注解表明这是一个JPA实体，ID注解表明这是唯一标识
 *
 * @author 小虫子的小日常
 */
@NoArgsConstructor
@Table(name = "READER")
@Entity
public class Reader implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;
    private String fullname;
    private String password;

    /**
     * 授予READER权限
     *
     * @param
     * @return
     * @date 2022-2-16
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // todo  Arrays.asList()
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    /**
     * 不过期
     * @date 2022-2-16
     * @param
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     * 不加锁
     * @date 2022-2-16
     * @param
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * 不过期
     * @date 2022-2-16
     * @param
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * 不禁用
     * @date 2022-2-16
     * @param
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Reader(String username, String fullname, String password) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
    }
}
