package com.analytics.data.repository;

import com.analytics.data.entity.CarModelAnalyticsEntity;
import com.analytics.data.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarPriceAnalyticsRepository extends JpaRepository<CarModelPriceEntity, Long> {

    Optional<CarModelAnalyticsEntity> findByModel(String model);

}
