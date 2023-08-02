package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;


    //Not: save() **************************************************************
    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){

       Product product= productRepository.save(productMapper.dtoToModel(productDto));

       return new ResponseEntity<>(product, HttpStatus.CREATED);

    }

    //Not:findAll()*************************************************************
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll(){
        return new ResponseEntity<>(productMapper.modelsToDtos(productRepository.findAll()),HttpStatus.OK);
    }

    //Not: findbyId ***************************************************************
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findbyId(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(productMapper.modelToDto(productRepository.findById(id).get()),HttpStatus.OK);
    }

    //Not: delete ***************************************************************
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
        ProductDto productDto = productMapper.modelToDto(productRepository.findById(id).get());

        productRepository.deleteById(productDto.getId());
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }










}
