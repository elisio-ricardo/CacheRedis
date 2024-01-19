package com.ricardo.cacheRedis.domain;

import java.io.Serializable;

//Precisa serializar para o redis entender
public record Product(Long id, String name, String description) implements Serializable {
}
