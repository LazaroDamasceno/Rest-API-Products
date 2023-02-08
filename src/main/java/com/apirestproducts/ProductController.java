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

    @PutMapping("/change)
    public ProductEntity replace(@RequestBody ProductEntity product) {
        return prodRep.save(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody ProductEntity product) {
        prodRep.delete(product);
    }

}
