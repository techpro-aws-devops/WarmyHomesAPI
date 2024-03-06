package com.project.payload.mappers;

import com.project.entity.business.Advert;
import com.project.entity.user.User;
import com.project.payload.request.abstracts.AbstractAdvertRequest;
import com.project.payload.request.abstracts.BaseAdvertRequest;
import com.project.payload.response.business.AdvertResponse;
import com.project.payload.response.business.helperresponse.CityForAdvertResponse;
import org.springframework.stereotype.Component;

@Component
public class AdvertMapper {

    // * title i slug a cevirirken kullanacagiz
    public String slugBuilt (String title) {
        return title.toLowerCase() // Küçük harfe çevir
                .replaceAll("[^a-z0-9]+", "-") // harf veya rakam olmayan karakterleri tire ile değiştir
                .replaceAll("^-|-$", ""); // Baştaki ve sondaki tireleri kaldır
    }

    public Advert mapAdvertRequestToAdvert(AbstractAdvertRequest advertRequest){


        return Advert.builder()
                .title(advertRequest.getTitle())
                .description(advertRequest.getDescription())
                .price(advertRequest.getPrice())
                .advert_type_id(advertRequest.getAdvert_type_id())
                .country_id(advertRequest.getCountry_id())
                .city_id(advertRequest.getCity_id())
                .district(advertRequest.getDistrict())
                .category_id(advertRequest.getCategory_id())
                .images(advertRequest.getImages())
                .location(advertRequest.getLocation())
                .build();
    }
    public AdvertResponse mapAdvertToAdvertResponse(Advert advert){
        return AdvertResponse.builder()
                .title(advert.getTitle())
                .description(advert.getDescription())
                .price(advert.getPrice())
                .advert_type_id(advert.getAdvert_type_id())
                .country_id(advert.getCountry_id())
                .city_id(advert.getCity_id())
                .id(advert.getId())
                .district(advert.getDistrict())
                .category_id(advert.getCategory_id())
                .images(advert.getImages())
                .location(advert.getLocation())
                .build();
    }

    public CityForAdvertResponse mapCityForAdvertToCityForAdvertResponse(String city, Integer amount){

        return CityForAdvertResponse.builder()
                .city(city)
                .amount(amount)
                .build();
    }
}
