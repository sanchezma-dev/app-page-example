package app.page.examplePage.services;

import app.page.examplePage.models.ProductMO;
import app.page.examplePage.repository.ProductJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductJPARepository repository;

    @Override
    public Page<ProductMO> findAll(Integer page, Integer size, String sort) {
        String[] sortParams = sort.split(",");
        Sort sortObj = Sort.by(Sort.Order.asc(sortParams[0])); // por defecto orden ascendente
        if (sortParams.length > 1 && "desc".equalsIgnoreCase(sortParams[1])) {
            sortObj = Sort.by(Sort.Order.desc(sortParams[0]));
        }
        Pageable pageable = PageRequest.of(page, size, sortObj);

        return repository.findAll(pageable);
    }
}
