package com.product.services;

import com.product.entities.Product;
import com.product.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Test
    void testToListAllproducts() {
        Product product = new Product();
//        product.get
//        List<Product> productList = new ArrayList<>();
//        doReturn().when(this.productRepository).findAll();
    }
}