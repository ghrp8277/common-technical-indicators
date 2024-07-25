package com.example.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.common.Market;
import java.util.Set;
import com.example.common.StockData;

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
    private Market market;

    @OneToMany(mappedBy = "stock")
    private Set<StockData> stockData;
}
