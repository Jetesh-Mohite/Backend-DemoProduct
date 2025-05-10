package Jitesh_FakeStore.FakeStore.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorReponseDTO {

    private String message;
    private Integer status;

    public ErrorReponseDTO(String message,Integer status){
        this.message = message;
        this.status = status;
    }
}
