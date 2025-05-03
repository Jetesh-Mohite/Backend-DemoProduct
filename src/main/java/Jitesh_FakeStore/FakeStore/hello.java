package Jitesh_FakeStore.FakeStore;


import jakarta.servlet.ServletOutputStream;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;
import java.util.ArrayList;

@RestController
@Getter
@Setter
@Data

public class hello {



    @GetMapping("/hello")
    public String print(){
        ArrayList<Integer> abc = new ArrayList<>();
        System.out.println("hello jitesh");
        return "hello abc";
    }

//    System.out.println("hello");

}
