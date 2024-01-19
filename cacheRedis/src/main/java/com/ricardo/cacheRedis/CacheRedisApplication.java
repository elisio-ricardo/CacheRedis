package com.ricardo.cacheRedis;

import com.ricardo.cacheRedis.Service.ProductService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching//è necessario ter o redis rodando na sua maquina, pode ser por docker
public class CacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheRedisApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(ProductService productService) {
        //sem cache ele vai fazer a consulta na memoria todas as vezes
        return args -> {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Id: 1: " + productService.getById(1L));
            System.out.println("Id: 2: " + productService.getById(2L));
            System.out.println("Id: 1: " + productService.getById(1L));
            System.out.println("Id: 1: " + productService.getById(1L));
            System.out.println("Id: 1: " + productService.getById(1L));
        };
    }


}
