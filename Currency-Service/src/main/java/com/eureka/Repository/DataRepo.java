package com.eureka.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.Entity.CurrencyData;

@Repository
public interface DataRepo extends JpaRepository<CurrencyData, Long> {

}
