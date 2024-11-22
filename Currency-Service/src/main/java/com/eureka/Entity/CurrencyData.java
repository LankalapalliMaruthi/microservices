package com.eureka.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	@Column(name="fromCurrency")
private String from;
	@Column(name="toCurrency")
private String to;
private Double quantity;
private Double conversion;
private Double totalAmount;
private LocalDateTime localDate;
}
