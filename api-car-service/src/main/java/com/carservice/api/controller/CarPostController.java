package com.carservice.api.controller;

import com.carservice.api.dto.CarPostDTO;
import com.carservice.api.message.KafkaProducerMessage;
import com.carservice.api.service.CarPostStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    private final Logger LOG = LoggerFactory.getLogger(CarPostController.class);

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        LOG.info("MAIN REST API: Producer Car Post information: {}", carPostDTO);
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable ("id") String id) {
        carPostStoreService.changeCrForSAle(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        carPostStoreService.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
