package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        boolean isFull = true;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                isFull = false;
                System.out.println("Продукт: " + "<" + product.getName() + ">" + " успешно добавлен в корзину");
                break;
            }
        }
        if (isFull) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public Product[] getProducts() {
        return products;
    }

    public void printBasket() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
        }
        System.out.println("Итого : " + "<" + totalPrice() + ">");
        if (totalPrice() == 0) {
            System.out.println("В корзине пусто ");
        }
    }

    public double totalPrice() {
        double result = 0.0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                result = result + products[i].getPrice();
            }
        }
        return result;
    }
    public boolean productAvailabilityCheck() {
        boolean equals = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                equals = Arrays.equals(products, getProducts());
            }
        }
        return equals;
    }
    public void emptyingTheTrash() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
            System.out.println(products[i]);
        }
    }
}
