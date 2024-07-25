package com.example.batchservice.entity.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "market_id", nullable = false)
    private com.example.batchservice.entity.common.Market market;

    @OneToMany(mappedBy = "stock")
    private Set<com.example.batchservice.entity.common.StockData> stockData;
}
