package Assignment;

import java.util.HashMap;

class Discounts {
    private double minimum;
    private double maximum;
    private double discount;



    public Discounts(double minimum, double maximum, double discount) {
        super();
        this.minimum = minimum;
        this.maximum = maximum;
        this.discount = discount;
    }

    public double getMinimum() {
        return minimum;
    }
    public double getMaximum() {
        return maximum;
    }
    public double getDiscount() {
        return discount;
    }
}

