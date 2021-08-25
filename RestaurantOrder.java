package Assignment;

import java.util.ArrayList;
import java.util.stream.IntStream;

class RestaurantOrder {
    private Restaurant restaurantReference;
    private ArrayList<CartItem> cartItems;

    public RestaurantOrder(Restaurant restaurantReference, CartItem foodItem) {
        this.restaurantReference = restaurantReference;
        this.cartItems = new ArrayList<>();
        this.addItem(foodItem);
    }

    public Restaurant getReference() {
        return this.restaurantReference;
    }

    public ArrayList<CartItem> getItemList() {
        return this.cartItems;
    };

    public void addItem(CartItem item) {
        // CartItem item = new CartItem(itemName,quantity,price);

        int index = IntStream.range(0, cartItems.size())
                .filter(i -> cartItems.get(i).getItemName().equals(item.getItemName())).findFirst().orElse(-1);

        if (index == -1) {
            cartItems.add(item);
        } else {
            cartItems.get(index).addQuantity();
        }
    }
}