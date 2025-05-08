package app;

public class WithoutDiscount implements Discountable {
    @Override
    public double applyDiscount(double totalPrice) {
        return 0;
    }
}
