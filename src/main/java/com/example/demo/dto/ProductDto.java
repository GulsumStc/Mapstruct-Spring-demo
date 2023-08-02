package com.example.demo.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductDto {


    @Id
    private int id;
    private String name;
    private String description;
    private String quantity;
    private long price;
  /*  private String itemId;*/



}
