package com.ricardo.cacheRedis.Service;


import com.ricardo.cacheRedis.domain.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    Map<Long, Product> products = new HashMap<>() {
        {
            put(1L, new Product(1L, "Notebook", "Macbook Pro"));
            put(2L, new Product(2L, "Notebook", "XPS"));
            put(3L, new Product(3L, "Notebook", "Alienware"));
            put(4L, new Product(4L, "Notebook", "Thinkpad"));
            put(5L, new Product(5L, "Notebook", "Zenbook"));
        }
    };


    @Cacheable("products")//è necessario ter o redis rodando na sua maquina, pode ser por docker

    public Product getById(Long id) {
        System.out.println("Buscando produtos");

        //simular a latencia pois é muito rapido
        simulateLatency();

        return products.get(id);
    }

    private void simulateLatency() {
        try {
            long time = 2000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

    }

}
