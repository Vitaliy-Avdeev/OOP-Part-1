package org.skypro.skyshop.basket;

import jdk.internal.icu.util.CodePointMap;
import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> basket;
    public ProductBasket() {
        basket = new HashMap<>();
    }
    public void addProduct(Product product) {
        String productName = product.getName();
        List<Product> productList = basket.getOrDefault(productName, new ArrayList<>());
        productList.add(product);
        basket.put(productName, productList);

    }
    public void printBasket() {
        StringBuilder basketPrint = new StringBuilder();
        int countSpecial = 0;
        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            String key = product.getKey();
            List<Product> value = product.getValue();
            for (Product s : value) {

                basketPrint.append(product).append("\n");
                if (product.isSpecial()) countSpecial++;
            }
            if (countSpecial != 0) {
                basketPrint.append("Специальных товаров: ").append(countSpecial).append("\n");
            }
            if (basketPrint.isEmpty()) {
                basketPrint.append("В корзине пусто");
            }
            System.out.println(basketPrint);
            String totalPrice1 = String.format("%.2f", totalPrice());
            System.out.println("Итого : < " + totalPrice1 + " > ");
        }
    }
        public double totalPrice() {
        double result = 0.0;
        if (basket.isEmpty()) return 0;
        for (Map.Entry<String, List<Product>> product : basket.entrySet() ) {
                result = product.getValue().getFirst().getPrice();

        }
        return result;


        }
    public boolean isHasProduct(String name) {
        if (basket.isEmpty()) return false;
        for (Map.Entry<String, List<Product>> product : basket.entrySet() ) {
            if (product.getValue().equals(name)) return true;
        }
        return false;
    }
    public void deleteBasket() {
        basket = new HashMap<>();
    }
    public Map removeProduct(String name) {
        //if (basket.isEmpty()) return new ArrayList<Product>();
        //ArrayList<Product> removedProducts = new ArrayList<>();
        if (basket.isEmpty()) return new HashMap<>();
        Map<String, List<Product>> removedProducts = new HashMap<>();


        List<Product> productList = basket.containsValue();
        while (productList.hasNext()) {

            Product p = iterator.next();
            if (p.getName().equals(name)) {
                List<Product> put = removedProducts.put();
                iterator.remove();
            }
            ;
        }
        return removedProducts;

    }
}
