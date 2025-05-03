package Jitesh_FakeStore.FakeStore.repository;


import Jitesh_FakeStore.FakeStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByDescriptionIgnoreCase(String description);

}
