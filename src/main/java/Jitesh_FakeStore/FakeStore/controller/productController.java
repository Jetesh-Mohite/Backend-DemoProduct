package Jitesh_FakeStore.FakeStore.controller;


import Jitesh_FakeStore.FakeStore.dto.FakeStoreProductDTO;
import Jitesh_FakeStore.FakeStore.dto.FakeStoreProductRespDTO;
import Jitesh_FakeStore.FakeStore.dto.ProductDescDTO;
import Jitesh_FakeStore.FakeStore.dto.ProductProjection;
import Jitesh_FakeStore.FakeStore.model.Product;
import Jitesh_FakeStore.FakeStore.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {
    @Autowired
    private ProductService productService;


    @GetMapping("demoProduct/projection/{name}")
    public ResponseEntity<ProductProjection> getProductProjectionByName(@PathVariable("name") String name){
        ProductProjection projection = productService.getProductProjection(name);
        return ResponseEntity.ok(projection);
    }


    @GetMapping("demoProduct/desc/{description}")
    public ResponseEntity<List<Product>> getProductByDescription(@PathVariable("description") String description){
        List<Product> resProd = productService.SeacrhProdByDesc(description);
        return ResponseEntity.ok(resProd);
    }

    @PostMapping("/demoProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product saveProduct = productService.saveProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @GetMapping("/demoProduct")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/demoProduct/{id}")
    public ResponseEntity<Product> getProdbyId(@PathVariable("id") int id){
        Product getData = productService.getProduct(id);
        return ResponseEntity.ok(getData);
    }

    @DeleteMapping("/demoProduct/{id}")
    public ResponseEntity<Boolean> removeProduct(@PathVariable("id") int id){
        boolean res = productService.deleteProduct(id);
        return ResponseEntity.ok(res);
    }

//    @PostMapping("/demoProduct")
//    public ResponseEntity<Product> alterProduct(@RequestBody Product product){
//        Product p = productService.updateProduct(id);
//    }


// below down is code for fakeStore API means calling 3rd party API's
    @GetMapping("/product")
    public FakeStoreProductDTO[] getAllProducts(){
        return productService.getAllProductFromFakeStore();
    }

    @GetMapping("/product/{id}")
    public FakeStoreProductRespDTO getProduct(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public FakeStoreProductDTO createProductData(@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.createProd(fakeStoreProductDTO);
    }

    @PutMapping("/product/{id}")
    public FakeStoreProductDTO replaceProductData(@PathVariable("id") int id, @RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.updateProd(id,fakeStoreProductDTO);
    }
}





