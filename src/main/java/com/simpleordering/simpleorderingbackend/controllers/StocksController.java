package com.simpleordering.simpleorderingbackend.controllers;

import com.simpleordering.simpleorderingbackend.models.Product;
import com.simpleordering.simpleorderingbackend.models.Stock;
import com.simpleordering.simpleorderingbackend.services.StockService;
import com.simpleordering.simpleorderingbackend.services.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StocksController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<Stock> getStockById(@PathVariable int stockId) {
        Stock stock = stockService.getStockById(stockId);
        if (stock != null) {
            return new ResponseEntity<>(stock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
