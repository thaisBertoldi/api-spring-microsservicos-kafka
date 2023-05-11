package com.carservice.api.controller;

import com.carservice.api.dto.OwnerPostDTO;
import com.carservice.api.service.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);
    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
        LOG.info("MAIN REST API: Creating new user: {}", ownerPostDTO);
        ownerPostService.createOwnerCar(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
