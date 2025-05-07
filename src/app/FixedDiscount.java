package app;

public class FixedDiscount implements Discountable{

    private final double discount;

    public FixedDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice > 2000 ? discount : 0;
    }
}
