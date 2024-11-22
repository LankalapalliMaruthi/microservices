package com.eureka.entity;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Currency_Exchange")

public class CurrencyExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	 @Column(name = "from_currency", nullable = false, length = 3)
private String from;
	 @Column(name = "to_currency", nullable = false, length = 3)
private String to;
private Double conversion;

}
