package com.example.demo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class CloudinaryController {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "johnsad",
            "api_key", "651998212777852",
            "api_secret", "zmLnemqvVP3LI_2HDe1fPB4oG7M"));

    /*
     * Todo: This is only work in front end side not in microservices.
     */

    @PostMapping("/upload")
    public ResponseEntity upload() throws IOException {

        Map uploadResult = cloudinary.uploader().upload("C:\\Users\\john brix17\\Downloads\\uploaded\\4.jpg", ObjectUtils.emptyMap());
        log.info("uploadResult: " + uploadResult);
        log.info("result of statusCode: " + uploadResult.get("secure_url"));

        String urlIsNotNull = uploadResult.get("secure_url").toString();

        return new ResponseEntity(urlIsNotNull, HttpStatus.OK);
    }
}
