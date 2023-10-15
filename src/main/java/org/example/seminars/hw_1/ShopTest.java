package org.example.seminars.hw_1;

import org.assertj.core.api.Assertions;
import org.example.seminars.Calculator.Calculator;
import org.example.seminars.hw_1.my_class_shop.Product;
import org.example.seminars.hw_1.my_class_shop.Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

    public class ShopTest {
        private Shop shop;

        @Before
        public void setup() {
            shop = new Shop();
        }

        @Test
        public void testSetProducts() {
            List<Product> products = new ArrayList<>();
            products.add(new Product("Product 1", 10));
            products.add(new Product("Product 2", 20));
            products.add(new Product("Product 3", 30));

            shop.setProducts(products);

            Assert.assertEquals(products, shop.getProducts());
        }

        @Test
        public void testGetMostExpensiveProduct() {
            List<Product> products = new ArrayList<>();
            products.add(new Product("Product 1", 10));
            products.add(new Product("Product 2", 20));
            products.add(new Product("Product 3", 30));

            shop.setProducts(products);

            Product mostExpensiveProduct = shop.getMostExpensiveProduct();

            Assert.assertEquals(products.get(2), mostExpensiveProduct);
        }

        @Test
        public void testSortProductsByPrice() {
            List<Product> products = new ArrayList<>();
            products.add(new Product("Product 3", 30));
            products.add(new Product("Product 1", 10));
            products.add(new Product("Product 2", 20));

            shop.setProducts(products);

            List<Product> sortedProducts = shop.sortProductsByPrice();

            List<Product> expectedSortedProducts = new ArrayList<>();
            expectedSortedProducts.add(new Product("Product 1", 10));
            expectedSortedProducts.add(new Product("Product 2", 20));
            expectedSortedProducts.add(new Product("Product 3", 30));

            Assert.assertEquals(expectedSortedProducts, sortedProducts);
        }

    @Test
    public void testCalculatingDiscount() {
        // Проверяем, что метод возвращает корректное значение с учетом скидки

        Assertions.assertThat(Calculator.calculatingDiscount(100, 20)).isEqualTo(80);
        Assertions.assertThat(Calculator.calculatingDiscount(200, 50)).isEqualTo(100);
        Assertions.assertThat(Calculator.calculatingDiscount(50, 10)).isEqualTo(45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculatingDiscountWithNegativePurchaseAmount() {
        // Проверяем, что метод выбрасывает исключение, если сумма покупки отрицательная
        Calculator.calculatingDiscount(-100, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculatingDiscountWithNegativeDiscountAmount() {
        // Проверяем, что метод выбрасывает исключение, если размер скидки отрицательный
        Calculator.calculatingDiscount(100, -20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculatingDiscountWithTooLargeDiscountAmount() {
        // Проверяем, что метод выбрасывает исключение, если размер скидки больше 100%
        Calculator.calculatingDiscount(100, 200);
    }
}
