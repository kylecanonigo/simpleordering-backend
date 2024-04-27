package com.simpleordering.simpleorderingbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "stock_table")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
    private Product product;

    private int quantity;
    private int shopNo;
}
