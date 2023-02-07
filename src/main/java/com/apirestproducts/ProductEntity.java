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
    private String prod_name;
    private String prod_brand;
    private String prod_type;
    private int quantity;
    private int price;

}
