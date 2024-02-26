package com.project.entity.business.helperentity;

import com.project.entity.business.Advert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category_property_values")
public class Category_Property_Value {
    //SongulCelik
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter name")
    @Size(max = 80,message = "Name must be maximum 100 characters")
    private String name;

    @ManyToOne
    private Category_Property_Key category_property_key_id;

    @ManyToOne
    private Advert advert;

}
