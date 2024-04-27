package com.simpleordering.simpleorderingbackend.services.impl;

import com.simpleordering.simpleorderingbackend.models.Product;
import com.simpleordering.simpleorderingbackend.models.Stock;
import com.simpleordering.simpleorderingbackend.repositories.StockRepository;
import com.simpleordering.simpleorderingbackend.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(int stockId) {
        Optional<Stock> stockOptional = stockRepository.findById(stockId);
        return stockOptional.orElse(null);
    }

    @Override
    public Stock addStock(Stock stock) {
        return null;
    }

    @Override
    public Stock updateStock(int stockId, Stock updatedStock) {
        return null;
    }

    @Override
    public void deleteStock(int stockId) {
        stockRepository.deleteById(stockId);
    }
}
