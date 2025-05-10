package Jitesh_FakeStore.FakeStore.exception;


import Jitesh_FakeStore.FakeStore.dto.ErrorReponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorReponseDTO> handleProductNotFound(ProductNotFoundException ex){
        ErrorReponseDTO errorReponseDTO = new ErrorReponseDTO(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorReponseDTO,HttpStatus.NOT_FOUND);

    }


}
