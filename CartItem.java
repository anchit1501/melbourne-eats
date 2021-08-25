package Assignment;

public class CartItem {
    private String itemName;
    private double itemCost;
    private int quantity;

    public CartItem(String itemName, int quantity, Double itemCost) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemCost = itemCost;

    }

    public String getItemName() {
        return this.itemName.toString();
    };

    public double getItemCost() {
        return this.itemCost;
    };

    public int getQuantity() {
        return this.quantity;
    };

    public void addQuantity() {
        this.quantity += 1;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(this.quantity).append("\t").append(this.itemName).append("\t").append(this.itemCost);
        return string.toString();
    }

}