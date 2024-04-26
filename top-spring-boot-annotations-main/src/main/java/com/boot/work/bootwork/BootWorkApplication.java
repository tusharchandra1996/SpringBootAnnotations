package com.boot.work.bootwork;

import com.boot.work.bootwork.config.MyConfigValues;
import com.boot.work.bootwork.entities.Product;
import com.boot.work.bootwork.repsitories.ProductRepository;
import com.boot.work.bootwork.services.CategoryService;
import com.boot.work.bootwork.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class BootWorkApplication implements CommandLineRunner {


    @Autowired
    private MyConfigValues values;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(BootWorkApplication.class, args);
        ProductService productService = container.getBean(ProductService.class);
        System.out.println(productService);
        productService.createProduct();
        CategoryService bean = container.getBean(CategoryService.class);
        System.out.println(bean);

        bean.getProductService().createProduct();

        bean.getCartService().addToCart();
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(values.getAppName());
//        System.out.println(values.getAppPort());
//        System.out.println(values.getAppDb());

        Product product = new Product();
        product.setName("Ipone 13 pro max");
        product.setShortDescription("This is very good phone");
        product.setLongDescription("this is long description of iphone");
        product.setPrice(85000);
        product.setLive(true);
        product.setInStock(true);
        this.productRepository.save(product);
        System.out.println("Product saved success");
    }
}
