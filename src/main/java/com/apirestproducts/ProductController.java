package com.apirestproducts;

import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/all/{first}/{last}")
    public List<ProductEntity> showFromRangeById(@PathVariable(value = "first") int first,
                                                 @PathVariable(value = "last") int last) {
        List<ProductEntity> selectedEntities = new ArrayList<>();
        for (int i = first; i < last; i++) {
            selectedEntities.add(showById(i));
        }
        return selectedEntities;
    }

    @GetMapping("/all/{id}/brand")
    public String getBrandById(@PathVariable(value = "id") int id) {
        return showAll().get(id-1).getBrand();
    }

    @GetMapping("/all/brands")
    public Map<Integer, String> getBrands() {
        return showAll().stream().collect(Collectors.toMap(k -> k.getId(), v -> v.getBrand()));
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

    @PutMapping("/change/price/{price}")
    public String replaceAllPrices(@PathVariable(value = "price") int price) {
        ProductEntity product;
        for (int i = 1; i <= showAll().size(); i++) {
            product = showById(i);
            product.setPrice(price);
            prodRep.save(product);
        }
        return Constants.HTTP_200;
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
        return Constants.HTTP_200;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody ProductEntity product) {
        prodRep.delete(product);
        return Constants.HTTP_200;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        prodRep.deleteById(id);
        return Constants.HTTP_200;
    }

}
