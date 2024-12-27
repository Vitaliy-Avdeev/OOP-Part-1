package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Коктель", 89.0);
        Product product2 = new Product("Пицца", 560.8);
        Product product3 = new Product("Роллы", 658.5);
        Product product4 = new Product("Картофель", 278.);
        Product product5 = new Product("Кола", 86.5);
        Product product6 = new Product("Напиток", 45.0);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        basket.printBasket();
        basket.productAvailabilityCheck();
        basket.emptyingTheTrash();

    }
}