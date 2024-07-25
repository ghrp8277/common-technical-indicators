package com.example.batchservice.entity.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(
        name = "stock_data",
        uniqueConstraints = @UniqueConstraint(columnNames = {"date", "stock_id"}),
        indexes = {
           @Index(name = "idx_stock_data_date", columnList = "date"),
           @Index(name = "idx_stock_data_stock_id", columnList = "stock_id")
       }
)
public class StockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "open_price", nullable = false)
    private Integer openPrice;

    @Column(name = "high_price", nullable = false)
    private Integer highPrice;

    @Column(name = "low_price", nullable = false)
    private Integer lowPrice;

    @Column(name = "close_price", nullable = false)
    private Integer closePrice;

    @Column(name = "volume", nullable = false)
    private Integer volume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private com.example.batchservice.entity.common.Stock stock;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "moving_average_12", joinColumns = @JoinColumn(name = "stock_data_id"))
    @Column(name = "value")
    @BatchSize(size = 100)
    private List<Double> movingAverage12;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "moving_average_20", joinColumns = @JoinColumn(name = "stock_data_id"))
    @Column(name = "value")
    @BatchSize(size = 100)
    private List<Double> movingAverage20;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "moving_average_26", joinColumns = @JoinColumn(name = "stock_data_id"))
    @Column(name = "value")
    @BatchSize(size = 100)
    private List<Double> movingAverage26;

    @Embedded
    private com.example.batchservice.entity.common.BollingerBands bollingerBands;

    @Embedded
    private com.example.batchservice.entity.common.MACD macd;

    @Column(name = "rsi")
    private Double rsi;
}