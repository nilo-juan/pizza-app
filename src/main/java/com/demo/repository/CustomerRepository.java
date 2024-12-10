package com.demo.repository;

import com.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByActive(Boolean active);
    List<Customer> findByActiveIsTrue();
    @Query("select c from Customer c where c.active = :active")
    List<Customer> findByActiveJpql(@Param("active") Boolean active);
    @Query(value = "select * from customers c where c.active = :active", nativeQuery = true)
    List<Customer> findByActiveNativeQuery(@Param("active") Boolean active);
    //
    Page<Customer> findAll(Pageable pageable);
    //
}
