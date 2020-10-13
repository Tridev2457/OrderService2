package com.example.orderservice2.serviceImpl;


import com.example.orderservice2.configuration.ProductConfig;
import com.example.orderservice2.model.AppleProduct;
import com.example.orderservice2.model.OrangeProduct;
import com.example.orderservice2.service.IProductCostCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnExpression("!'${offer.valid}'")
public class ProductCostCalculator implements IProductCostCalculator {
    AppleProduct appleItem;
    OrangeProduct orangeItem;

    @Autowired
    ProductConfig productConfig;

    public ProductCostCalculator(ProductConfig productConfig) {
        this.appleItem = new AppleProduct("Apple", 0.60);;
        this.orangeItem = new OrangeProduct("Orange", 0.25);
        this.productConfig = productConfig;
    }

    public Double calculateItemCost(String[] items) {

        Double totalCost = 0.0;
        for (String item : items){
            if(item.equalsIgnoreCase(appleItem.getItemName())){
                totalCost+=appleItem.getItemPrice();
            }else if(item.equalsIgnoreCase(orangeItem.getItemName())){
                totalCost+=orangeItem.getItemPrice();
            }else{
                System.out.println("We sell only oranges and apples");
            }
        }


        return totalCost;

    }

}
