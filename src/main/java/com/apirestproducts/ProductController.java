package com.apirestproducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/id/{id}")
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

    @PutMapping("/change/name/{id}/{name}")
    public ProductEntity replaceNameById(@PathVariable(value = "id") int id, @PathVariable(value = "name") String name) {
        ProductEntity product = showById(id);
        product.setName(name);
        return prodRep.save(product);
    }

    @PutMapping("/change/brand/{id}/{brand}")
    public ProductEntity replaceBrandById(@PathVariable(value = "id") int id, @PathVariable(value = "brand") String brand) {
        ProductEntity product = showById(id);
        product.setBrand(brand);
        return prodRep.save(product);
    }

    @PutMapping("/change/type/{id}/{type}")
    public ProductEntity replaceTypeById(@PathVariable(value = "id") int id, @PathVariable(value = "type") String type) {
        ProductEntity product = showById(id);
        product.setType(type);
        return prodRep.save(product);
    }

    @PutMapping("/change/price/{id}/{type}")
    public ProductEntity replaceTypeById(@PathVariable(value = "id") int id, @PathVariable(value = "type") int price) {
        ProductEntity product = showById(id);
        product.setPrice(price);
        return prodRep.save(product);
    }

    @PutMapping("/change/quantity/{id}/{quantity}")
    public ProductEntity replaceQuantityById(@PathVariable(value = "id") int id, @PathVariable(value = "quantity") int quantity) {
        ProductEntity product = showById(id);
        product.setQuantity(quantity);
        return prodRep.save(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody ProductEntity product) {
        prodRep.delete(product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        prodRep.deleteById(id);
    }

}
