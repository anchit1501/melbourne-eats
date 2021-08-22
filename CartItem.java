package Assignment;

public class CartItem
{
    public String restaurantName;
    public String itemName;
    public double itemCost;
    public int quantity;



    public CartItem(String restaurantName, String itemName,
                            int quantity, Double itemCost)
    {
        this.restaurantName = restaurantName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemCost = itemCost;


    }

    public void addExisting(CartItem otherItem)
    {
        this.quantity = this.quantity + otherItem.quantity;
    }

    public String stringVersion()
    {
        return itemName+" cost: "+itemCost+" qty: "+quantity+" restaurant: "+
                restaurantName;
    }


}