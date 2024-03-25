package com.project.payload.response.business;

import com.project.entity.business.*;
import com.project.entity.business.helperentity.AdvertStatusRole;
import com.project.entity.business.helperentity.Advert_Type;
import com.project.entity.business.helperentity.Category_Property_Value;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AdvertPageableResponse {


    private  Long id;

    private String title;


    private String description;


    //private String slug;


    private Double price;


    private byte status;

    private Boolean is_active;


    private Integer view_count;

    private String location;

    private Advert_Type advert_type_id;

    private Country country_id;

    private City city_id;

    private District district;


    private List<Image> images;

    private Category category_id;

    private LocalDateTime createdAt;

    //private LocalDateTime update_at;

    private List<Category_Property_Value> category_property_values;

    private List<Tour_Request> tourRequestList;

   // private List<Log> logList;
}
