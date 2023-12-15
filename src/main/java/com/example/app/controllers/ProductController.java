package com.example.app.controllers;

import com.example.app.dtos.RequestProductDto;
import com.example.app.models.ProductModel;
import com.example.app.services.ProductService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @GetMapping()
    public ResponseEntity list() {
        List<ProductModel> products = productService.list();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity store(@RequestBody @Valid RequestProductDto productDto) {
        ProductModel productSaved = productService.store(productDto);

        return ResponseEntity.ok(productSaved);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Valid ProductModel product) {
        try {
            ProductModel productSaved = productService.update(product);
            return ResponseEntity.ok(productSaved.toString());
        } catch (Exception e) {
            logger.error("Error to update", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
