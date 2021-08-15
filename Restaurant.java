package Assignment;

import java.util.HashMap;

class Restaurant {
    private String name;
    private String category;
    private double deliveryFee;
    private HashMap<String,Double> foodItems;



    public Restaurant(String name, String category, double deliveryFee, HashMap<String,Double> foodItems) {
        super();
        this.name = name;
        this.category = category;
        this.deliveryFee = deliveryFee;
        this.foodItems = foodItems;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public Double getDeliveryFee() {
        return deliveryFee;
    }
    public  HashMap<String,Double> getFoodItems() {return foodItems; }
}



