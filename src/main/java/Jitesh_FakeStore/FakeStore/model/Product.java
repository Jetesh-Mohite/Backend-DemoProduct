package Jitesh_FakeStore.FakeStore.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    @ManyToOne
    private Category category;
    private double price;
    private double rating;
    private int quantity;

}
