package com.example.common;

import jakarta.persistence.*;
import lombok.Data;
import com.example.common.Stock;
import java.util.Set;

@Entity
@Data
@Table(name = "markets", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "market")
    private Set<Stock> stocks;
}
