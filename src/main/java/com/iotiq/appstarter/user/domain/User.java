package com.iotiq.appstarter.user.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends AbstractPersistable<UUID> implements UserDetails {

    @Embedded
    private Username username;
    @Embedded
    private Credentials credentials;
    @Embedded
    private AccountSecurity accountSecurity;
    @Embedded
    private Person personalInfo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountSecurity.getAuthorities();
    }

    @Override
    public String getPassword() {
        return credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return username.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountSecurity.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountSecurity.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentials.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return accountSecurity.isAccountNonLocked();
    }
}
