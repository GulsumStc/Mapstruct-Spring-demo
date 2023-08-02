package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper( componentModel = "spring"  /*,  imports = UUID.class*/)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


//    @Mapping(source = "product.desc", target="description", defaultValue = "description")
  //  @Mapping(target ="itemId", expression = "java(UUID.randomUUID().toString())")
   // @Mapping(source = "product.items", target = "itemsList")
    ProductDto modelToDto(Product product);


//    @Mapping(source = "product.desc", target="description")
    List<ProductDto> modelsToDtos(List<Product> product);

    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productDto);



}
