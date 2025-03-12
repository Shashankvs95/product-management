package com.product.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Product entity.
 */
@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @Version
    @JsonProperty("version")
    private int version;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private int price;
}

