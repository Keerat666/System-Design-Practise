import java.util.*;
import ingredients.ingredient;
import recipe.recipe;

public class machine {

    static ingredient coffee = new ingredient(75, "coffee", 30);
    static ingredient sugar = new ingredient(25, "sugar", 30);
    static ingredient milk = new ingredient(25, "milk", 30);
    static ArrayList<ingredient> rawMaterials = new ArrayList<ingredient>();

    static ArrayList<recipe> coffeeMenu = new ArrayList<recipe>();

    public static void initialiseMenu() {

        rawMaterials.add(coffee);
        rawMaterials.add(sugar);
        rawMaterials.add(milk);

        HashMap<ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(coffee, 3);
        latteRecipe.put(sugar, 2);
        latteRecipe.put(milk, 1);
        recipe latte = new recipe(latteRecipe, "Latte");

        HashMap<ingredient, Integer> blackCoffeeRecipe = new HashMap<>();
        blackCoffeeRecipe.put(coffee, 5);
        blackCoffeeRecipe.put(sugar, 1);
        blackCoffeeRecipe.put(milk, 1);
        recipe blackCoffee = new recipe(blackCoffeeRecipe, "Black Coffee");
        coffeeMenu.add(latte);
        coffeeMenu.add(blackCoffee);
    }

    public static void displayStock() {
        System.out.println("The stock looks like : ");
        System.out.println("Name\tStock");

        for (int i = 0; i < rawMaterials.size(); i++) {
            System.out.println(rawMaterials.get(i).getName() + "\t" + rawMaterials.get(i).getStock());
        }
    }

    public static void displayMenu() {
        System.out.println("Menu Items");

        for (int i = 0; i < coffeeMenu.size(); i++) {
            System.out.println("Press " + (i + 1) + " for buying " + coffeeMenu.get(i).getRecipeName());
        }
        System.out.println("Enter your choice : ");
        processOrder();
    }

    public static void processOrder() {
        Scanner ab = new Scanner(System.in);
        int n = ab.nextInt();

        recipe chosenRecipe = coffeeMenu.get(n - 1);
        if (checkForStock(chosenRecipe)) {
            System.out.println("Dispensing your " + chosenRecipe.getRecipeName());
            updateStock(chosenRecipe);

        } else {
            System.out.println("OUT OF STOCK ALERT!");
            System.out.println("Not enough ingredients left for " + chosenRecipe.getRecipeName());
            System.out.println("Please restock to dispense this drink");

        }

    }

    public static void updateStock(recipe r) {
        HashMap<ingredient, Integer> chosenRecipe = new HashMap<>();
        chosenRecipe = r.getRecipeInstruction();
        for (Map.Entry<ingredient, Integer> set : chosenRecipe.entrySet()) {
            int currentStock = set.getKey().getStock();
            set.getKey().setStock(currentStock - set.getValue());
        }
    }

    public static boolean checkForStock(recipe r) {
        boolean status = true;
        HashMap<ingredient, Integer> chosenRecipe = new HashMap<>();
        chosenRecipe = r.getRecipeInstruction();
        for (Map.Entry<ingredient, Integer> set : chosenRecipe.entrySet()) {
            if (set.getValue() > set.getKey().getStock()) {
                status = false;
                break;
            }
        }

        return status;

    }

    public static void reStock() {
        for (int i = 0; i < rawMaterials.size(); i++) {
            rawMaterials.get(i).setStock(30);
        }
    }

    public static void main(String args[]) {

        Scanner ab = new Scanner(System.in);
        initialiseMenu();

        while (true) {
            System.out.println(
                    "Press 1 for viewing stock of ingredients\nPress 2 for available drinks\nPress 3 for restocking ingredients\nPress 4 for quitting");
            int choice = ab.nextInt();
            switch (choice) {
                case 1:
                    displayStock();
                    break;
                case 2:
                    displayMenu();
                    break;
                case 3:
                    reStock();
                    break;
                case 4:
                    reStock();
                    break;

                default:
                    break;
            }
        }

    }

}
