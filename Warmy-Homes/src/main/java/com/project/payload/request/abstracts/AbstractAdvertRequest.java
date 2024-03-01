package com.project.payload.request.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.business.*;
import com.project.entity.business.helperentity.Advert_Type;
import com.project.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AbstractAdvertRequest extends BaseUserRequest {

    @NotNull(message = "Please enter your title")
    @Size(min = 5, max = 150,message = "Your title should be at least 5 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your title must consist of the characters .")
    private String title;

    @NotNull(message = "Please enter your username")
    @Size( max = 300,message = "Your description should be at big 300 chars")
    private String description;

    @NotNull
    @Size(min = 5, max = 200 ,message = "Your slug should be at least 5 chars")
    private String slug;

    @NotNull(message = "Please enter your price")
    private Double price;

    @NotNull
    private Integer status=0;

    private Boolean built_in=false;

    @NotNull
    private Boolean is_active=true;

    @NotNull
    private Integer view_count=0;

    @NotNull(message = "Please enter your location")
    private String location;

    @NotNull(message = "Please enter your advert type")
    private Long advert_type_id;

    @NotNull(message = "Please enter your country")
    private Long country_id;

    @NotNull(message = "Please enter your city")
    private Long city_id;

    @NotNull(message = "Please enter your district")
    private Long district;

    @NotNull(message = "Please enter your user")
    private Long user;

    @NotNull(message = "Please enter your category")
    private Long category_id;

    @NotNull(message = "Please enter your advert type")
    private Image images;


    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "US")
    private LocalDateTime createdAt;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "US")
    private LocalDateTime update_at;

    @NotNull(message = "Please enter your category_property_values")
    private List<Long> category_property_values;

    @NotNull(message = "Please enter your tourRequestList")
    private List<Long> tourRequestList;

    @NotNull(message = "Please enter your logList")
    private List<Long> logList;




}
