package com.example.app.controllers;

import com.example.app.dtos.RequestProductDto;
import com.example.app.models.ProductModel;
import com.example.app.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

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
    public void update(@RequestBody @Valid RequestProductDto productDto) {
        productService.update(productDto);
    }
}
