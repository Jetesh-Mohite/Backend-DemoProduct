package Jitesh_FakeStore.FakeStore.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@Entity
public class Category extends BaseModel{
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products;

//    public List<Product> getProducts(){
//        return products;
//    }


}
