package com.chei.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;


import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Use GenerationType.IDENTITY for auto-increment
    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(name = "name")
    //if the field name and the column name are the same
// you don't have to use @Column annotation
   @NotBlank(message="Name should not be null")
    private String name;


//    @Column(name = "age")
    private Long age=0l;

//    @Column(name = "location")
    private String location;

//    @Column(name = "email")
@NotBlank(message="Email should not be null")
@Email(message="Please enter a valid email address")
    private String email;

//    @Column(name = "department")
@NotBlank(message="Department should not be null")
    private String department;
    @CreationTimestamp
    @Column(name = "create_at",nullable = false,updatable = false)

    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
