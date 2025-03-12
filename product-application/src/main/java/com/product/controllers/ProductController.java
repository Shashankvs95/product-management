package com.product.controllers;

import com.product.entities.Product;
import com.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;


/**
 * Product controller.
 */
@RestController("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("product/new")
    public static String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("products", this.productService.listAllProducts());
        System.out.println("Returning products:");
        return "products" + model.getClass();
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "productshow";
    }

    /* Afficher le formulaire de modification du Product*/
    @PutMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "productform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(@RequestBody Product product) {
        this.productService.saveProduct(product);
        LOGGER.info("Product saved to database");
        return "redirect:/product/";
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        this.productService.deleteProduct(id);
        return "redirect:/products";
    }

}
