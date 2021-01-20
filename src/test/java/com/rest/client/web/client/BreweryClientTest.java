package com.rest.client.web.client;

import com.rest.client.web.model.BeerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());
        Assertions.assertNotNull(beerDTO);
    }

    @Test
    void saveNewBeer() {
        BeerDTO beerDTO = BeerDTO.builder().build();
        URI uri = breweryClient.saveNewBeer(beerDTO);
        Assertions.assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDTO beerDTO = BeerDTO.builder().build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}