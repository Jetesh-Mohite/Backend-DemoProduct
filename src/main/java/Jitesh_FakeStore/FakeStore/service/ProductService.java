package Jitesh_FakeStore.FakeStore.service;


import Jitesh_FakeStore.FakeStore.client.FakeStoreClient;
import Jitesh_FakeStore.FakeStore.dto.FakeStoreProductDTO;
import Jitesh_FakeStore.FakeStore.dto.FakeStoreProductRespDTO;
import Jitesh_FakeStore.FakeStore.dto.ProductProjection;
import Jitesh_FakeStore.FakeStore.exception.ProductNotFoundException;
import Jitesh_FakeStore.FakeStore.model.Product;
import Jitesh_FakeStore.FakeStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product){
       Product saveProduct = productRepository.save(product);
       return saveProduct;
    }

    public boolean deleteProduct(int productId){
        productRepository.deleteById(productId);
        return true;
    }

    public Product getProduct(int productId){
        Optional<Product> getProduct = productRepository.findById(productId);
        if(getProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }else{
            return  getProduct.get();
        }
    }

    public ProductProjection getProductProjection(String prodName){
        return productRepository.findByName(prodName);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public List<Product> SeacrhProdByDesc( String description){
        List<Product> matchProd = productRepository.findAllByDescriptionIgnoreCase(description);
        return matchProd;
    }

    public Product updateProduct(Product newProduct, int productId){
        Product saveProduct = getProduct(productId);
//        newProduct.setId(productId);
        Product updateProduct = productRepository.save(newProduct);
        return updateProduct;
    }


    // below for Fake store API

    public FakeStoreProductDTO[] getAllProductFromFakeStore(){
        return fakeStoreClient.getAllProducts();
    }

    public FakeStoreProductRespDTO getProductById(int prodId){
        return fakeStoreClient.getProduct(prodId);
    }

    public FakeStoreProductDTO createProd(FakeStoreProductDTO data){
        return fakeStoreClient.createProduct(data);
    }

    public FakeStoreProductDTO updateProd(int id,FakeStoreProductDTO data){
        return fakeStoreClient.updateProduct(id,data);
    }
}
