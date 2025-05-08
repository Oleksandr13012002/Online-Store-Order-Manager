package app;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    public static void main(String... args){

        final int firstOrderId = 1;
        final int secondOrderId = 2;
        final int thirdOrderId = 3;

        Order firstOrder = new Order(firstOrderId, new FixedDiscount(100));
        Order secondOrder = new Order(secondOrderId, new PercentageDiscount(10));
        Order thirdOrder = new Order(thirdOrderId, new WithoutDiscount());

        firstOrder.addProducts(
                new Product("OPPO A52", 6000, ProductCategory.ELECTRONICS),
                new Product("Harry Potter", 600, ProductCategory.BOOKS),
                new Product("Golden Pen", 100, ProductCategory.HOME),
                new Product("DELL Inspiron 3952", 25000, ProductCategory.ELECTRONICS)
        );
        secondOrder.addProducts(
                new Product("Hat", 350, ProductCategory.CLOTHING),
                new Product("Mop", 200, ProductCategory.HOME),
                new Product("Toys set", 1000, ProductCategory.HOME),
                new Product("Table Lamp", 500, ProductCategory.ELECTRONICS)
        );

        thirdOrder.addProducts(
                new Product("Bookcase", 2500, ProductCategory.HOME)
        );

        Map<Integer, Order> orders = new HashMap<>();
        orders.put(firstOrder.getOrderId(), firstOrder);
        orders.put(secondOrder.getOrderId(), secondOrder);
        orders.put(thirdOrder.getOrderId(), thirdOrder);

        for(Map.Entry<Integer, Order> order : orders.entrySet()){
            System.out.printf("Замовлення №%d\n", order.getKey());
            System.out.println("  Список товарів: " + order.getValue().getProducts());
            System.out.printf("  Загальна сума: %.2f\n", order.getValue().getTotalPrice(false));
            System.out.printf("  Знижка: %.2f\n", order.getValue().getDiscount());
            System.out.printf("  Сума після знижки: %.2f\n\n", order.getValue().getTotalPrice(true));
        }
    }
}
