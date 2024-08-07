package com.scaler.productservicejul24.inheritancedemo.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
