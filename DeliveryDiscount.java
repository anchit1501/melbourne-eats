package Assignment;

import java.util.HashMap;

class DeliveryDiscount extends Discounts{
    private int restaurantCount;
    private double discount;

    public DeliveryDiscount(double minimum, double maximum, double discount) {
        super(minimum, maximum, discount);
        this.restaurantCount = restaurantCount;
        this.discount = discount;
    }

    public int getRestaurantCount() {
        return restaurantCount;
    }
    public double getDiscount() {
        return discount;
    }
}

