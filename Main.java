package Assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Program Initialized");
        System.out.println("Reading Restaurants.txt");
//        ArrayList file1BufferString = Utils.readFile("Restaurants.txt");

        System.out.println("Reading Discounts.txt");
//        ArrayList file2BufferString = Utils.readFile("Discounts.txt");

        boolean input = false;
        int option = -1;

                while(!input){
                  input  = first_loading_screen().isValid();
                  option = first_loading_screen().getOption();
                }
        System.out.println(option);

    }
    static final class Validation {
        private int maxValue;
        private int option;

        public Validation(int maxValue, int option) {
            this.maxValue = maxValue;
            this.option = option;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public int getOption() {
            return option;
        }
    }

    static final class firstScreenReturn {
        private boolean valid;
        private int option;

        public firstScreenReturn(boolean valid, int option) {
            this.valid = valid;
            this.option = option;
        }

        public boolean isValid() {
            return valid;
        }

        public int getOption() {
            return option;
        }
    }

    public static firstScreenReturn first_loading_screen() {
        String welcome_message = "Welcome to Melbourne Eats\n";
        welcome_message += "------------------------------------------------\n";
        welcome_message += "> Select from main menu\n";
        welcome_message += "------------------------------------------------\n";
        welcome_message += "1) Browse by category\n";
        welcome_message += "2) Search by restaurant\n";
        welcome_message += "3) Checkout\n";
        welcome_message += "4) Exit";
        System.out.println(welcome_message);
        Scanner input = new Scanner(System.in);
        boolean validation = inputValidator(new Validation(input.nextInt(),4));
        return new firstScreenReturn(validation,input.nextInt());
    }

    public static boolean inputValidator(Validation data){

        if(data.getOption()<1 || data.getOption()>data.getMaxValue()){
            System.out.println("Please enter a correct option");
            return false;
        }
        else return true;

    }
}

class Restraunt {
    private String name;
    private String category;
    private double deliveryFee;
    private HashMap<String,Double> foodItems;

    public void Restaurant(String name, String category, double deliveryFee, HashMap foodItems) {
//            super();
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
}



