package com.simpleordering.simpleorderingbackend.services;

import com.simpleordering.simpleorderingbackend.models.Customer;
import com.simpleordering.simpleorderingbackend.models.Product;
import com.simpleordering.simpleorderingbackend.models.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();
    Stock getStockById(int stockId);
    Stock addStock(Stock stock);
    Stock updateStock(int stockId, Stock stock);
    void deleteStock(int stockId);
}
