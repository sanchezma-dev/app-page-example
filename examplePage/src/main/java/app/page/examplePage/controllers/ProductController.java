package app.page.examplePage.controllers;

import app.page.examplePage.models.ProductMO;
import app.page.examplePage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/page/example")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<Page<ProductMO>> products(@RequestParam(defaultValue = "0") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size,
                                                    @RequestParam(defaultValue = "name") String sort) {


        Page<ProductMO> products = productService.findAll(page, size, sort);


        return ResponseEntity.ok(products);
    }




    /** Otra forma de hacer la paginación, eligiendo los datos a mostrar */
//    @GetMapping("/products")
//    public ResponseEntity<Map<String, Object>> products(@RequestParam(defaultValue = "0") Integer page,
//                                                        @RequestParam(defaultValue = "10") Integer size) {
//
//        Page<ProductMO> products = productService.findAll(page, size);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("products", products.getContent());
//        response.put("currentPage", products.getNumber());
//        response.put("totalItems", products.getTotalElements());
//        response.put("totalPages", products.getTotalPages());
//
//        return ResponseEntity.ok(response);
//    }

}
