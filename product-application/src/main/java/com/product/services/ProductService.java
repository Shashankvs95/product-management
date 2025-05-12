package com.product.services;

import com.product.entities.Product;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}
