package com.rest.client.web.client;

import com.rest.client.web.model.BeerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public static final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;

    private RestTemplate restTemplate;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDTO.class);
    }

    public void updateBeer(UUID uuid, BeerDTO beerDTO) {
        restTemplate.put(apiHost + BEER_PATH_V1 + uuid.toString(), beerDTO);
    }

    public URI saveNewBeer(BeerDTO beerDTO){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDTO);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + uuid.toString());
    }


}
