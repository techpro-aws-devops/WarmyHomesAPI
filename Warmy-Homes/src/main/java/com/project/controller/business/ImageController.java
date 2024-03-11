package com.project.controller.business;

import com.project.entity.business.Image;
import com.project.payload.response.business.ImageResponse;
import com.project.service.business.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    //I-01 /images/:imageId-get Bir reklamın görüntüsünü alacak
    @PreAuthorize("hasAnyAuthority('ANONYMOUS')")
    @GetMapping("/{imageId}")
    public ResponseEntity<Image> getImageById(@PathVariable Long imageId) {
        Image image = imageService.getImageById(imageId);
        return ResponseEntity.ok(image);
    }

    //I-02 /images/:advertId-post Bir ürünün resim(ler)ini yükleyecektir
    @PostMapping("/{advertId}")
    public ResponseEntity<List<Long>> uploadImages(
            @RequestParam("images") List<MultipartFile> images,
            @PathVariable long id) {
        List<Long> imageIds = imageService.uploadImages(images,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageIds);
    }

    //I-03 /images/:image_ids-delete
    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN','CUSTOMER')")
    @DeleteMapping("/{imageIds}")
    public ResponseEntity<Void> deleteImages(@PathVariable List<Long> imageIds) {
        imageService.deleteImages(imageIds);
        return ResponseEntity.noContent().build();
    }


        // I-04 /images/:imageId-put
    @PutMapping("/{imageId}")
    public ImageResponse setFeaturedImage(@PathVariable Long imageId) {
        return  null;// imageService.setFeaturedImage(imageId);

    }

        // I-04 /images/:imageId-put Bir görüntünün öne çıkan alanını ayarlayacaktır
        @PutMapping("/images/:imageId")
        public ResponseEntity<String> setFeaturedImage1(@PathVariable Long imageId) {
            imageService.setFeaturedImage(imageId);
            return ResponseEntity.status(HttpStatus.OK).body("Image feature updated successfully.");
        }
}
