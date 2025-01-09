package app.page.examplePage.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "products")
@ToString  // Agregar esta anotación de Lombok para mejor debugging
public class ProductMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;
}