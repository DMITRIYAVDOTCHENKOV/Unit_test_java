package org.example;

import org.example.seminars.hw_1.my_class_shop.Product;
import org.example.seminars.hw_1.my_class_shop.Shop;


import java.util.List;

public class Main {
    public static void main(String[] args) {



        // Выводим список продуктов, отсортированный по возрастанию цены
        System.out.println("Список продуктов, отсортированный по возрастанию цены:");
        List<Product> sortedProductsByPrice = Shop.sortProductsByPrice();
        for (Product product : sortedProductsByPrice) {
            System.out.println(product.getTitle() + " - " + product.getCost());
        }

        // Выводим самый дорогой продукт
        System.out.println("Самый дорогой продукт:");
        Product mostExpensiveProduct = Shop.getMostExpensiveProduct();
        System.out.println(mostExpensiveProduct.getTitle() + " - " + mostExpensiveProduct.getCost());
    }
}