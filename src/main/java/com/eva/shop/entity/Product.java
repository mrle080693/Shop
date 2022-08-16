package com.eva.shop.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "description")
    private String description;

    public Product() {
    }

    public Product(@NotNull @Min(1) @Max(100) String name, @NotNull @Min(1) @Max(1000) String description) {
        this.name = name;
        this.description = description;
    }

    public Product(@NotNull long id, @NotNull @Min(1) @Max(100) String name, @NotNull @Min(1) @Max(1000) String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                name.equals(product.name) &&
                description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
