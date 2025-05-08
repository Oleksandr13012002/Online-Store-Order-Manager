package app;

public class PercentageDiscount implements Discountable{

    private final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice / 100 * percent;
    }
}
