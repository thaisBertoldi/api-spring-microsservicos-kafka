package com.carservice.api.service;

import com.carservice.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();

    void changeCrForSAle(CarPostDTO carPost, String id);

    void removeCarForSale(String id);
}
