package Assignment;

import java.util.ArrayList;

class RestaurantOrder
{
    private Restaurant restaurantReference;
    private ArrayList<CartItem> cartItems;

    public RestaurantOrder(Restaurant restaurantReference){
        this.restaurantReference = restaurantReference;
        this.cartItems = new ArrayList<>();
    }

    public Restaurant getReference() {return this.restaurantReference; }
}