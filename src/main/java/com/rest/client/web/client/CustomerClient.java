package com.rest.client.web.client;

import com.rest.client.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public static final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;

    private RestTemplate restTemplate;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }


    public CustomerDTO getCustomerById(UUID uuid){
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDTO.class);
    }

    public void updateCustomer(UUID uuid, CustomerDTO customerDTO) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), customerDTO);
    }

    public URI saveCustomer(CustomerDTO customerDTO){
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDTO);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + uuid.toString());
    }
}
