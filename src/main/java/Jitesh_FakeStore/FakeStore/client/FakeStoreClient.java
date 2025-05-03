package Jitesh_FakeStore.FakeStore.client;

import Jitesh_FakeStore.FakeStore.dto.FakeStoreProductDTO;
import Jitesh_FakeStore.FakeStore.dto.FakeStoreProductRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplate restTemplate;


    public FakeStoreProductDTO[] getAllProducts(){
        String getAllProductUrl = "https://fakestoreapi.com/products";
         return restTemplate.getForObject(getAllProductUrl,FakeStoreProductDTO[].class);
    }

    public FakeStoreProductRespDTO getProduct(int productId){
        String getSingleProduct = "https://fakestoreapi.com/products/" + productId;
        return restTemplate.getForObject(getSingleProduct,FakeStoreProductRespDTO.class);
    }

    public FakeStoreProductDTO createProduct(FakeStoreProductDTO input){
        String createUrl= "https://fakestoreapi.com/products";
        return restTemplate.postForObject(createUrl,input,FakeStoreProductDTO.class);
    }

    public FakeStoreProductDTO updateProduct(int id,FakeStoreProductDTO input){
        String createUrl= "https://fakestoreapi.com/products/" + id;
        return restTemplate.patchForObject(createUrl,input,FakeStoreProductDTO.class);
    }
}
