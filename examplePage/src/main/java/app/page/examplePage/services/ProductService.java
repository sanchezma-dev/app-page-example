package app.page.examplePage.services;

import app.page.examplePage.models.ProductMO;
import org.springframework.data.domain.Page;

public interface ProductService {

    Page<ProductMO> findAll(Integer page, Integer size, String sort);
}
