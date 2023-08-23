package com.testing.firebasespringoauth.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends FirebaseBaseUser {

    private String firstName;

    private String lastName;
}
/* ^qf:user */
