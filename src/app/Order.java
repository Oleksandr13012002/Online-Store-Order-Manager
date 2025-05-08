package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final int orderId;
    private final List<Product> products;
    private Discountable discountable;
    private double totalPrice;
    private double discount;

    public Order(int orderId, Discountable discountable, ArrayList<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.discountable = discountable;
        totalPrice = calculateTotalPrice();
        discount = calculateDiscount();
    }

    public Order(int orderId, Discountable discountable) {
        this(orderId, discountable, new ArrayList<>());
    }

    public void addProducts(Product... products){
        this.products.addAll(Arrays.asList(products));
        totalPrice = calculateTotalPrice();
        discount = calculateDiscount();
    }

    public void clear(){
        this.products.clear();
        totalPrice = calculateTotalPrice();
        discount = calculateDiscount();
    }

    public double getTotalPrice(boolean discount){
        return discount ? totalPrice - this.discount : totalPrice;
    }

    public void recalculateTotalPrice(){
        totalPrice = calculateTotalPrice();
        discount = calculateDiscount();
    }

    private double calculateDiscount(){
        return discountable.applyDiscount(totalPrice);
    }

    private double calculateTotalPrice(){
        double totalPrice = 0;

        for(Product product : products){
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setDiscountable(Discountable discountable) {
        this.discountable = discountable;
        recalculateTotalPrice();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                '}';
    }
}
