package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fid", nullable = false, unique = true)
    private Footbollers footboller;

    @NotEmpty
    @NotNull
    @Column(columnDefinition = "VARCHAR(1) CHECK (gender IN ('a', 'b'))" ,name = "teams", nullable = false)
    private String teams;



}
