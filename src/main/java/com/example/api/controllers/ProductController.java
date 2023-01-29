package com.example.api.controllers;

import com.example.api.entities.Product;
import com.example.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  private ProductService service;

  @PostMapping("/product")
  public Product add(@RequestBody Product product) {
    return service.save(product);
  }

  @PostMapping("/products")
  public List<Product> add(@RequestBody List<Product> products) {
    return service.save(products);
  }

  @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
  public Product find(@PathVariable int id) {
    return service.get(id);
  }

//  @RequestMapping(value = "/product", method = RequestMethod.GET)
//  public Product find(@RequestParam(value = "name") String name) {
//    return service.get(name);
//  }

  @GetMapping("/products")
  public List<Product> find() {
    return service.get();
  }
}
