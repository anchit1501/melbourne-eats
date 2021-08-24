package Assignment;

public class CartItem
{
    public String itemName;
    public double itemCost;
    public int quantity;



    public CartItem(String itemName,
                            int quantity, Double itemCost)
    {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemCost = itemCost;


    }

}