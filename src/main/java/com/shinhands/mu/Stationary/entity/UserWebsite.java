package com.shinhands.mu.Stationary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_website")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWebsite {
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name="user_name",length = 255)
    private String userName;
    @Column(name="address",length = 255)
    private String address;
    @Column(name="phone")
    private Long phone;
    @Column(name="idcart")
    private Long idCart;
    @Column(name="idaccount")
    private Long idAccount;
    @Column(name = "deleted")
    private Long deleted;


//    @OneToMany(mappedBy = "userWebsite", cascade = CascadeType.ALL)
//    private List<RoleFuntion> roleFuntionList;
//
//    @OneToOne(mappedBy = "userWebsite")
//    private Account account;

}