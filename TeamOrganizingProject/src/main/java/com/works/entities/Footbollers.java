package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Footbollers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;


    @Size(min = 2, max = 15)
    @NotEmpty
    @NotNull
    @Column(length = 100)
    private String name;


    @Size(min = 2)
    @NotEmpty
    @NotNull
    @Column(length = 100)
    private String surname;

    @Email
    @NotEmpty
    @NotNull
    @Column(unique = true, length = 150)
    private String email;


    @NotEmpty
    @NotNull
    private String password;

    @NotNull
    @Positive
    @Min(18)
    private Integer age;


}
