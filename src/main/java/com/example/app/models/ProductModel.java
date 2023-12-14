package com.example.app.models;

import com.example.app.dtos.RequestProductDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;

    public ProductModel(RequestProductDto productDto) {
        this.name = productDto.name;
        this.price_in_cents = productDto.price_in_cents;
    }
}
