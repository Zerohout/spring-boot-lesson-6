package ru.geekbrains.springbootlesson6.persist.repo;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.springbootlesson6.persist.entity.Product;

import java.math.BigDecimal;

public class ProductSpecification {

    public static Specification<Product> nameLike(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Product> minPriceFilter(BigDecimal minPrice) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> maxPriceFilter(BigDecimal maxPrice) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }
}
