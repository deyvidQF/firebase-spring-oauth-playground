package com.testing.firebasespringoauth.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity(name = "baseUser")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FirebaseBaseUser extends BaseEntity {

    @Column(nullable = false)
    private String email;

    private boolean active = true;


    /* qf:security_firebase */
    @Column(nullable = false)
    private String firebaseId;
    /* ^qf:security_firebase */

    private String firebaseToken;
    /* ^qf:firebase_notification */

    /* qf:security */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    /* ^qf:security */


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.toString()));
    }


}
/* ^qf:user */