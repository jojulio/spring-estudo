package com.example.app.services;

import com.example.app.dtos.RequestProductDto;
import com.example.app.models.ProductModel;
import com.example.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductModel store(RequestProductDto productDto) {
        ProductModel productModel = new ProductModel(productDto);
        return productRepository.save(productModel);
    }

    public List<ProductModel> list() {
        return productRepository.findAll();
    }

    public void update(RequestProductDto productDto)
    {
        ProductModel product = productRepository.getReferenceById(productDto.id);
    }
}
