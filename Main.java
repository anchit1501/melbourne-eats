package Assignment;

import jdk.jshell.execution.Util;

import java.util.*;

import static java.lang.Double.parseDouble;

public class Main {
    private static   Restaurant[] obj;
    public CartItem[] cartObject;

    public Main(CartItem[] cartObject) {
        super();
        this.cartObject = cartObject;
    }

    public CartItem[] getCartObject() {
        return cartObject;
    }
    // public CartItem addItem(CartItem item) { cartObject[cartObject.length] = new
    // cartObject(item)}

    public static void main(String[] args) throws Exception {

        System.out.println("Program Initialized");
        System.out.println("Reading Restaurants.txt");
        ArrayList file1BufferString = Utils.readFile("Restaurants.txt");
        // System.out.println("main"+file1BufferString);

        System.out.println("Reading Discounts.txt");
        ArrayList file2BufferString = Utils.readFile("Discounts.txt");

      obj = new Restaurant[file1BufferString.size()];

        String[] str = Utils.getStringArray(file1BufferString);

        for (int i = 0; i < file1BufferString.size(); i++) {
            if (str[i].split(",").length <= 3)
                System.out.println("Incomplete data for: " + str[i].split(",")[0]);
            // System.out.print("----" + temp + "\n ");
            else {
                String[] temp = str[i].split(",");
                String restaurant_name = temp[0];
                String restaurant_category = temp[1];
                double restaurant_delivery = parseDouble(temp[2].substring(1));
                HashMap<String, Double> restaurant_foodItems = new HashMap<String, Double>();
                for (int j = 3; j < temp.length; j++) {
                    String[] temporary = temp[j].split("-");
                    restaurant_foodItems.put(temporary[0], parseDouble(temporary[1].substring(1)));
                }
                obj[i] = new Restaurant(restaurant_name, restaurant_category, restaurant_delivery,
                        restaurant_foodItems);
            }
        }

        first_loading_screen(obj);
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

    public static void first_loading_screen(Restaurant[] obj) {
        String message = "Welcome to Melbourne Eats\n";
        message += "------------------------------------------------\n";
        message += "> Select from main menu\n";
        message += "------------------------------------------------\n";
        message += "1) Browse by category\n";
        message += "2) Search by restaurant\n";
        message += "3) Checkout\n";
        message += "4) Exit";
        System.out.println(message);

        boolean validation = false;
        int input = 0;
        while (!validation) {
            input = new Scanner(System.in).nextInt();
            validation = Utils.inputValidator(new Validation(4, input));
        }

        switch (input) {
            case 1:
                System.out.println("Selected Option 1");
                select_by_category(obj);
                break;
            case 2:
                System.out.println("Selected Option 2");
                search_restaurant_by_name(obj);
                break;
            case 3:
                System.out.println("Selected Option 3");
                break;
            case 4:
                System.out.println("Thank You");
                System.exit(0);
                break;
            default:
                break;
            // code block
        }
    }

    public static void select_by_category(Restaurant[] obj) {

        Set<String> categories = new HashSet<String>();
        for (int i = 0; i < obj.length; i++)
            categories.add(obj[i].getCategory());

        String message = "------------------------------------------------\n";
        message += "> Select by category\n";
        message += "------------------------------------------------\n";
        for (int item = 0; item < categories.size(); item++)
            message += item + 1 + ") " + categories.toArray()[item] + "\n";
        message += categories.size() + 1 + ") Return to Main Menu";

        System.out.println(message);

        // int input = new Scanner(System.in).nextInt();
        // boolean validation = Utils.inputValidator(new Validation(categories.size() +
        // 1, input));
        // while (!validation) {
        // validation = Utils.inputValidator(new Validation(categories.size() + 1,
        // input));
        // }

        boolean validation = false;
        int input = 0;
        while (!validation) {
            input = new Scanner(System.in).nextInt();
            validation = Utils.inputValidator(new Validation(categories.size() + 1, input));
        }

        if (input <= categories.size()) {
            restaurant_list_by_category(categories.toArray()[input - 1], obj);
        } else {
            first_loading_screen(obj);
        }
    }

    public static void restaurant_list_by_category(Object category, Restaurant[] obj) {

        ArrayList<Restaurant> filtered_list = Utils.filterByCategory(category, obj);

        String message = "------------------------------------------------\n";
        message += "> Select from restaurant list\n";
        message += "------------------------------------------------\n";
        System.out.println(message);

        for (int i = 0; i < filtered_list.size(); i++) {
            Restaurant restaurant = filtered_list.get(i);
            System.out.println(i + 1 + ") " + restaurant.getName());
        }

        System.out.println(filtered_list.size() + 1 + ") Return to Main Menu");

        boolean validation = false;
        int input = 0;
        while (!validation) {
            input = new Scanner(System.in).nextInt();
            validation = Utils.inputValidator(new Validation(filtered_list.size() + 1, input));
        }

        if (input > 0 && input <= filtered_list.size()) {
            restaurant_menu(filtered_list.get(input - 1), obj);
        } else {
            first_loading_screen(obj);
        }
    }

    public static void search_restaurant_by_name(Restaurant[] obj) {
        ArrayList<Restaurant> filtered_list = new ArrayList<>();

        String message = "------------------------------------------------\n";
        message += "> Enter a restaurant name\n";
        message += "------------------------------------------------\n";

        message += "1) Return to Main Menu";
        System.out.println(message);

        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        String searchString = sc.nextLine();

        System.out.println("You searched: " + searchString);

        if (searchString == "1")
            System.out.println("Back to main menu");
        else {
            filtered_list = Utils.searchByName(searchString, obj);
            if (filtered_list.size() > 0)
                restaurant_list_by_name(filtered_list);
        }
    }

    public static void restaurant_list_by_name(ArrayList<Restaurant> list) {
        String message = "------------------------------------------------\n";
        message += "> Select from restaurant list\n";
        message += "------------------------------------------------\n";
        System.out.println(message);

        for (int i = 0; i < list.size(); i++) {
            Restaurant restaurant = list.get(i);
            System.out.println(i + 1 + ") " + restaurant.getName());
        }

        System.out.println(list.size() + 1 + ") Return to Main Menu");

        boolean validation = false;
        int input = 0;
        while (!validation) {
            input = new Scanner(System.in).nextInt();
            validation = Utils.inputValidator(new Validation(list.size() + 1, input));
        }

        if (input > 0 && input <= list.size()) {
            restaurant_menu(list.get(input - 1), obj);
        } else {
            first_loading_screen(obj);
        }

    }

    public static void restaurant_menu(Restaurant restaurant, Restaurant[] obj) {
        String message = "------------------------------------------------\n";
        message += "> Select a food item from " + restaurant.getName() + "\n";
        message += "------------------------------------------------\n";
        System.out.println(message);
        final int[] index = { 0 };
        restaurant.getFoodItems().entrySet().forEach(entry -> {
            System.out.println(index[0] + 1 + " ) " + entry.getKey() + " " + entry.getValue());
            index[0]++;
        });
        System.out.println(restaurant.getFoodItems().size() + 1 + " ) No More");

        int input = 0;
        while (input != restaurant.getFoodItems().size() + 1) {
            input = new Scanner(System.in).nextInt();
            if (input < 1 && input > restaurant.getFoodItems().size() + 1)
                System.out.println("Please enter a valid input");
            else if (input == restaurant.getFoodItems().size() + 1) {
                first_loading_screen(obj);
            } else {
                System.out.println(
                        restaurant.getFoodItems().get(restaurant.getFoodItems().keySet().toArray()[input - 1]));
            }

        }
    }
}
