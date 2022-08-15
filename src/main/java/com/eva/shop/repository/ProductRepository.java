package com.eva.shop.repository;

import com.eva.shop.entity.Product;
import com.eva.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
