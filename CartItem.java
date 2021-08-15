package Assignment;

public class CartItem
{
    public String itemName;
    public int itemCost;
    public int quantity;
    public String restaurantName;


    public CartItem(String itemName, int itemCost,
                            int quantity, String restaurantName)
    {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.quantity = quantity;
        this.restaurantName = restaurantName;
    }

    public void add(CartItem otherItem)
    {
        this.quantity = this.quantity + otherItem.quantity;
    }

    public String stringVersion()
    {
        return itemName+" cost: "+itemCost+" qty: "+quantity+" restaurant: "+
                restaurantName;
    }
}