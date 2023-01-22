package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BreweryCustomerClientTest {
    @Autowired
    BreweryClient breweryClient;

    @Test
    void getCustomerById() {
        CustomerDto dto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("New Customer").build();
        URI uri = breweryClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Update Beer").build();

        breweryClient.updateCustomer(customerDto.getId(), customerDto);
    }

    @Test
    void deleteBeerById() {
        breweryClient.deleteCustomerById(UUID.randomUUID());
    }
}
