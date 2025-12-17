package se.java.composeapi.service;

import se.java.composeapi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> searchProductsByName(String name);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    boolean testDatabaseConnection();
}
