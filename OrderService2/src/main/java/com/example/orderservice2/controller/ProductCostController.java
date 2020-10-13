package com.example.orderservice2.controller;


import com.example.orderservice2.service.IProductCostCalculator;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductCostController {

    @Autowired
    IProductCostCalculator itemCostCalculator;


    @PostMapping("/v1/api/item/cost")
    public double calculateItemCost(@NotNull @RequestBody String[] itemsList){
        return itemCostCalculator.calculateItemCost(itemsList);
    }

}
