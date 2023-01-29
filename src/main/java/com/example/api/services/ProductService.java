package com.example.api.services;

import com.example.api.entities.Product;
import com.example.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Product save(Product product) {
    return repository.save(product);
  }

  public List<Product> save(List<Product> products) {
    return repository.saveAll(products);
  }

  public List<Product> get() {
    return repository.findAll();
  }

  public Product get(int id) {
    return repository.findById(id).orElse(null);
  }

  public Product get(String name) {
    return repository.findByName(name);
  }

  public String delete(int id) {
    repository.deleteById(id);

    return "Product removed " + id;
  }

  public Product update(Product product){
    Product existingProduct = repository.findById(product.getId()).orElse(null);

    if (existingProduct != null) {
      existingProduct.setName(product.getName());
      existingProduct.setQuantity(product.getQuantity());
      existingProduct.setPrice(product.getPrice());

      return repository.save(existingProduct);
    }

    return null;
  }
}
