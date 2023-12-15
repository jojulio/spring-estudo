package com.example.app.services;

import com.example.app.dtos.RequestProductDto;
import com.example.app.models.ProductModel;
import com.example.app.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    private static final ModelMapper mapper = new ModelMapper();

    public ProductModel store(RequestProductDto productDto) {
        ProductModel productModel = new ProductModel(productDto);
        return productRepository.save(productModel);
    }

    public List<ProductModel> list() {
        return productRepository.findAll();
    }

    @Transactional
    public ProductModel update(ProductModel productModel)
    {
        // ProductModel product = productRepository.findById(productDto.id).orElseThrow(RuntimeException::new);
//        ProductModel productModel = mapper.map(productDto, ProductModel.class);
        return productRepository.save(productModel);
    }
}
