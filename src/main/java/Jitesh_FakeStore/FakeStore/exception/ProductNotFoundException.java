package Jitesh_FakeStore.FakeStore.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){}

    public ProductNotFoundException(String message){
        super(message);
    }
}
