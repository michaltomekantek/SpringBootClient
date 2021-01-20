package com.rest.client.web.client;

import com.rest.client.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDTO customerDTO = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }

    @Test
    void updateCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void saveCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().build();
        URI uri = customerClient.saveCustomer(customerDTO);
        assertNotNull(uri);
    }

    @Test
    void deleteBeer() {
        customerClient.deleteBeer(UUID.randomUUID());
    }
}