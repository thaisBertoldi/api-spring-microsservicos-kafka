package com.carservice.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //cria todos os getter e setters
@Builder //construtor com apenas alguns atributos
@NoArgsConstructor //construtor com nenhum atributo
@AllArgsConstructor //construtor com todos os atributos
@JsonInclude
public class CarPostDTO {

    private String model;

    private String brand;

    private Double price;

    private String description;

    private String engineVersion;

    private String city;

    private String createdDate;

    private String ownerName;

    private Long ownerId;

    private String ownerType;

    private String contact;

}
