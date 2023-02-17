package com.apirestproducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository prodRep;

    @GetMapping("/all")
    public List<ProductEntity> showAll() {
        return prodRep.findAll();
    }

    @GetMapping("/all/{id}")
    public ProductEntity showById(@PathVariable(value="id") int id) {
        return prodRep.findById(id);
    }

    @PostMapping("/add")
    public ProductEntity add(@RequestBody ProductEntity product) {
        return prodRep.save(product);
    }

    @PutMapping("/change")
    public ProductEntity replace(@RequestBody ProductEntity product) {
        return prodRep.save(product);
    }

    @PutMapping("/change/{id}/name/{name}")
    public ProductEntity replaceNameById(@PathVariable(value = "id") int id,
                                         @PathVariable(value = "name") String name) {
        ProductEntity product = showById(id);
        product.setName(name);
        return prodRep.save(product);
    }

    @PutMapping("/change/{id}/brand/{brand}")
    public ProductEntity replaceBrandById(@PathVariable(value = "id") int id,
                                          @PathVariable(value = "brand") String brand) {
        ProductEntity product = showById(id);
        product.setBrand(brand);
        return prodRep.save(product);
    }

    @PutMapping("/change/{id}/type/{type}")
    public ProductEntity replaceTypeById(@PathVariable(value = "id") int id,
                                         @PathVariable(value = "type") String type) {
        ProductEntity product = showById(id);
        product.setType(type);
        return prodRep.save(product);
    }

    @PutMapping("/change/{id}/price/{price}")
    public ProductEntity replacePriceById(@PathVariable(value = "id") int id,
                                          @PathVariable(value = "price") int price) {
        ProductEntity product = showById(id);
        product.setPrice(price);
        return prodRep.save(product);
    }

    @PutMapping("/change/{id}/quantity/{quantity}")
    public ProductEntity replaceQuantityById(@PathVariable(value = "id") int id,
                                             @PathVariable(value = "quantity") int quantity) {
        ProductEntity product = showById(id);
        product.setQuantity(quantity);
        return prodRep.save(product);
    }

    @PutMapping("/change/price/{price}")
    public String replaceAllPrices(@PathVariable(value = "price") int price) {
        ProductEntity product;
        for (int i = 1; i <= showAll().size(); i++) {
            product = showById(i);
            product.setPrice(price);
            prodRep.save(product);
        }
        return "200 OK";
    }

    @PutMapping("/change/quantity/{quantity}")
    public String replaceAllQuantities(@PathVariable(value = "quantity") int quantity) {
        ProductEntity product;
        for (int i = 1; i <= showAll().size(); i++) {
            product = showById(i);
            product.setQuantity(quantity);
            prodRep.save(product);
        }
        return "200 OK";
    }

    @PutMapping("/change/{firstIndex}/{lastIndex}/price/{price}")
    public String replacePricesOfARange(@PathVariable(value = "price") int price,
                                      @PathVariable(value = "firstIndex") int firstIndex,
                                      @PathVariable(value = "lastIndex") int lastIndex) {
        ProductEntity product;
        for (int i = firstIndex; i <= lastIndex; i++) {
            product = showById(i);
            product.setPrice(price);
            prodRep.save(product);
        }
        return "200 OK";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody ProductEntity product) {
        prodRep.delete(product);
        return "200 OK";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        prodRep.deleteById(id);
        return "200 OK";
    }

}
