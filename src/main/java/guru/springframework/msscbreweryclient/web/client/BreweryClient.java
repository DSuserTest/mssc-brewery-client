package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreInvalidFields = false)
@Component
public class BreweryClient {
    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String CUSTOMER_PATH_V1 = "api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID id){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + id.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID id , BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + id.toString(), beerDto);
    }

    public void deleteBeerById(UUID id){
        restTemplate.delete(apihost + BEER_PATH_V1 + id);
    }

    public CustomerDto getCustomerById(UUID id){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + id.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID id , CustomerDto customerDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + id.toString(), customerDto);
    }

    public void deleteCustomerById(UUID id){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + id);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
