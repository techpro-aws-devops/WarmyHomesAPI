package com.project.entity.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.business.helperentity.AdvertStatusRole;
import com.project.entity.business.helperentity.Advert_Type;
import com.project.entity.business.helperentity.Category_Property_Value;
import com.project.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "t_advert")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Advert_Type advert_type_id;


    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country_id;


    private String slug;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city_id;


    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;


    @OneToOne
    private AdvertStatusRole status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    private Boolean builtIn = false;

    @ManyToOne
    private Category category_id;


    private Boolean isActive;


    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "US")
    private LocalDateTime createdAt;


    private Integer viewCount;

    @OneToMany(mappedBy = "advert_id",cascade = CascadeType.REMOVE)
    private List<Image> images;

    @Column(name = "update_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "US")
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "advert")
    private List<Category_Property_Value> category_property_values;

    @OneToMany(mappedBy = "advert_id", cascade = CascadeType.REMOVE)
    private List<Tour_Request> tourRequestList;

    @OneToMany(mappedBy = "advert_id", cascade = CascadeType.REMOVE)
    private List<Log> logList;

    @OneToMany(mappedBy = "advert", cascade = CascadeType.REMOVE)
    private List<Favorite> favorites;

}
