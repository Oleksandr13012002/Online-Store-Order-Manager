package app;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    public static void main(String... args){

        Product phone = new Product("OPPO A52", 6000, ProductCategory.ELECTRONICS);
        Product book = new Product("Harry Potter", 600, ProductCategory.BOOKS);
        Product hat = new Product("Hat", 350, ProductCategory.CLOTHING);
        Product mop = new Product("Mop", 200, ProductCategory.HOME);

        final int firstOrderId = 1;
        final int secondOrderId = 2;
        final double discount = 100;

        Order firstOrder = new Order(firstOrderId, new FixedDiscount(100));
        Order secondOrder = new Order(secondOrderId, new FixedDiscount(50));

        firstOrder.addProducts(phone, book);
        secondOrder.addProducts(hat, mop);

        Map<Integer, Order> orders = new HashMap<>();
        orders.put(firstOrderId, firstOrder);
        orders.put(secondOrderId, secondOrder);

        for(Map.Entry<Integer, Order> order: orders.entrySet()){
            System.out.printf("Замовлення №%d\n", order.getKey());
            System.out.println("  Список товарів: " + order.getValue().getProducts());
            System.out.printf("  Загальна сума: %.2f\n", order.getValue().getTotalPrice(false));
            System.out.printf("  Знижка: %.2f\n", order.getValue().getDiscount());
            System.out.printf("  Сума після знижки: %.2f\n\n", order.getValue().getTotalPrice(true));
        }
    }
}
