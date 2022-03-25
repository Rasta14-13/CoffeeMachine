package machine;
import java.util.Scanner;

public class CoffeeMachine {

    static final int WATER_esp = 250;
    static final int BEANS_esp = 16;
    static final int COST_esp = 4;
    static final int WATER_lat = 350;
    static final int MILK_lat = 75;
    static final int BEANS_lat = 20;
    static final int COST_lat = 7;
    static final int WATER_cap = 200;
    static final int MILK_cap = 100;
    static final int BEANS_cap = 12;
    static final int COST_cap = 6;
    static final int DISS_cups = 1;
    static int Curr = 550;
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;

    public static void main(String[] args) {
            menu();
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String input = sc.nextLine();
        sc.reset();
        switch (input) {
            case "buy":
                menuCoffee();
                break;
            case "fill":
                toFill();
                break;
            case "take":
                System.out.println("\nI gave you $" + Curr + "\n");
                Curr -= Curr;
                menu();
                break;
            case "remaining":
                printMass();
                menu();
                break;
            default:
                break;
        }
    }

    static void printMass() {
        System.out.println("\nThe coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + Curr + " of money\n");
    }

    static void menuCoffee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String inputUser = sc.next();
        sc.reset();
        switch (inputUser) {
            case "1":
                if (water >= WATER_esp && beans >= BEANS_esp && cups >= 1) {
                    water -= WATER_esp;
                    beans -= BEANS_esp;
                    cups -= DISS_cups;
                    Curr += COST_esp;
                    System.out.println("I have enough resources, making you a coffee!\n");
                    menu();
                } else if (water < WATER_esp) {
                    System.out.println("Sorry, not enough water!\n");
                    menu();
                } else if (beans < BEANS_esp) {
                    System.out.println("Sorry, not enough beans!\n");
                    menu();
                } else if (cups == 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                    menu();
                }
                break;
            case "2":
                if (water >= WATER_lat && milk >= MILK_lat && beans >= BEANS_lat && cups >= 1) {
                    water -= WATER_lat;
                    beans -= BEANS_lat;
                    milk -= MILK_lat;
                    cups -= DISS_cups;
                    Curr += COST_lat;
                    System.out.println("I have enough resources, making you a coffee!\n");
                    menu();
                } else if (water < WATER_lat) {
                    System.out.println("Sorry, not enough water!\n");
                    menu();
                } else if (milk < MILK_lat) {
                    System.out.println("Sorry, not enough milk!\n");
                    menu();
                } else if (beans < BEANS_lat) {
                    System.out.println("Sorry, not enough beans!\n");
                    menu();
                } else if (cups == 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                    menu();
                }
                break;
            case "3":
                if (water >= WATER_cap && milk >= MILK_cap && beans >= BEANS_cap && cups >= 1) {
                    water -= WATER_cap;
                    milk -= MILK_cap;
                    beans -= BEANS_cap;
                    cups -= DISS_cups;
                    Curr += COST_cap;
                    System.out.println("I have enough resources, making you a coffee!\n");
                    menu();
                } else if (water < WATER_cap) {
                    System.out.println("Sorry, not enough water!\n");
                    menu();
                }  else if (milk < MILK_cap) {
                    System.out.println("Sorry, not enough milk!\n");
                    menu();
                } else if (beans < BEANS_cap) {
                    System.out.println("Sorry, not enough beans!\n");
                    menu();
                } else if (cups == 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                    menu();
                }
                break;
            default:
                menu();
        }
    }

    static void toFill() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write how many ml of water you want to add:\n");
        int WATER_temp = sc.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n");
        int MILK_temp = sc.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n");
        int BEANS_temp = sc.nextInt();
        System.out.print("Write how many disposable cups of coffee you want to add:\n");
        int DISPOSABLE_temp = sc.nextInt();
        water += WATER_temp;
        milk += MILK_temp;
        beans += BEANS_temp;
        cups += DISPOSABLE_temp;
        sc.reset();
        menu();
    }
}
