package pizzaordersystem;

import java.util.Scanner;
import java.util.ArrayList;

public class Pizzaorderdriver {

    public static void printWelcomeMessage() {
        System.out.println("------------------------------------");
        System.out.println("Welcome to the Pizza Order Program!");
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printWelcomeMessage();

        ArrayList<Pizza> pizzas = new ArrayList<>();

        System.out.println("Enter the total pizzas you would like to order: ");
        int totalPizzas = scanner.nextInt();

        // Reading input regarding pizza size and pizza toppings
        for (int i = 0; i < totalPizzas; ++i) {
            Pizza pizza = new Pizza();

            ArrayList<String> toppings = new ArrayList<>();

            String pizzaSize;
            System.out.println("Enter the size of the pizza Large, Medium, Small: ");
            pizzaSize = scanner.next();
            pizza.setSize(pizzaSize);

            int totalToppings;
            System.out.println("Enter the total amount of toppings on the pizza: ");
            totalToppings = scanner.nextInt();

            for (int j = 0; j < totalToppings; ++j) {
                System.out.println("Enter the topping: ");
                String topping = scanner.next();
                toppings.add(topping);
            }

            pizza.setToppings(toppings);
            pizzas.add(pizza);
        }


        // Creating PizzaOrder object and relevant information with regards to order
        PizzaOrder order = new PizzaOrder(pizzas);
        ((Object) order).calculateTotalOrderCost();
        order.printOrderSummary();


        // Cleanup
        scanner.close();
    }
}