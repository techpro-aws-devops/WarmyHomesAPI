package com.project.entity.business.helperentity;

import javax.persistence.*;

@Entity
@Table(name = "t_advertType")
public class Advert_Type {
    //EnesBilgic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;

    @Column(name = "built_in", nullable = false)
    private boolean builtIn;
}
