package app.page.examplePage.repository;

import app.page.examplePage.models.ProductMO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductMO, Integer> {

}
