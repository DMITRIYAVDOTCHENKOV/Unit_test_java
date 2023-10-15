package org.example.seminars.hw_1.my_class_shop;



public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(String title, Integer cost) {
        this.cost = cost;
        this.title = title;
    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Product other = (Product) obj;
//        return Objects.equals(title, other.title) && cost == other.cost;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, cost);
//    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + title + '\'' +
                ", price=" + cost +
                '}';
    }
}
