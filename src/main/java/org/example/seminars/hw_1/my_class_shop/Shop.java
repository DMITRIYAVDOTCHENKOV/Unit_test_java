package org.example.seminars.hw_1.my_class_shop;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private static List<Product> products;

    // Геттеры, сеттеры:
    public  List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public static List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно

        Collections.sort(products, Comparator.comparingDouble(Product::getCost));
        return products;
        }



    // Метод должен вернуть самый дорогой продукт
    public static Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return null;
        }
        Product mostExpensiveProduct = products.get(0);
        for (Product product : products) {
            if (product.getCost() > mostExpensiveProduct.getCost()) {
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }

}