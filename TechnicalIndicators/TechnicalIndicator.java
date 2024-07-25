package com.example.batchservice.entity.common;

import java.util.List;
import java.util.Map;

public interface TechnicalIndicator {
    void calculate(List<Double> prices);
    Map<String, List<Double>> getResults();
}
