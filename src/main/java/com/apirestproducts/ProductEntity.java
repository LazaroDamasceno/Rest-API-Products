package com.apirestproducts;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String brand;
    private String type;
    private int quantity;
    private int price;

}
