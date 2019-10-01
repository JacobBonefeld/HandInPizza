import java.util.Scanner;

public class PizzaOrder {

    public static void main(String[] args) {

        showMenu();                   // Store number of chosen pizza


        /*COMMENTS FROM ROBERT
        only way ive been able to break it was during topping selection if i choose "three" instead of 3 it exits - dont really break just avoid toppings

        and when a topping is chosen, it outputs topping 2 - might be confusing if u choose topping 1, choose second topping might be better wording.

        * */

        /* Changes after Robert test
           - Changed message when topping 2 needs to be chosen
           - Changed message for exiting topping selection to be less confusing
         */

    }


    public static void showMenu(){


        String pizza1 = "Margherita: Tomato & cheese";                      // Declare all pizzas
        String pizza2 = "Hawaii: Tomato, cheese, ham & pineapple";
        String pizza3 = "Italiano: Tomato, cheese & pepperoni";
        String pizza4 = "Marinara: Tomato, garlic & basil";
        String pizza5 = "Carbonara: Tomato, cheese, eggs & bacon";
        String pizza6 = "Americano: Tomato, cheese, sausage & french fries";
        String pizza7 = "Tonno: Tomato, cheese, tuna & onions";
        String pizza8 = "Pugliese: Tomato, cheese, oregano & onions";
        String pizza9 = "Crudo: Tomato, cheese & Parma ham";
        String pizza10 = "Tedesca: Tomato, cheese & Vienna sausage";

        int pizza1Price = 60;                                               // Declare all pizza prices
        int pizza2Price = 75;
        int pizza3Price = 70;
        int pizza4Price = 65;
        int pizza5Price = 70;
        int pizza6Price = 70;
        int pizza7Price = 75;
        int pizza8Price = 65;
        int pizza9Price = 70;
        int pizza10Price = 70;

        System.out.printf("--------------------------- PIZZA MENU ---------------------------\n");    // Prints the menu
        System.out.printf("------------------------------------------------------------------\n");
        System.out.printf("1. %-50s Price DKK %d\n",pizza1,pizza1Price);
        System.out.printf("2. %-50s Price DKK %d\n",pizza2,pizza2Price);
        System.out.printf("3. %-50s Price DKK %d\n",pizza3,pizza3Price);
        System.out.printf("4. %-50s Price DKK %d\n",pizza4,pizza4Price);
        System.out.printf("5. %-50s Price DKK %d\n",pizza5,pizza5Price);
        System.out.printf("6. %-50s Price DKK %d\n",pizza6,pizza6Price);
        System.out.printf("7. %-50s Price DKK %d\n",pizza7,pizza7Price);
        System.out.printf("8. %-50s Price DKK %d\n",pizza8,pizza8Price);
        System.out.printf("9. %-50s Price DKK %d\n",pizza9,pizza9Price);
        System.out.printf("10. %-49s Price DKK %d\n",pizza10,pizza10Price);
        System.out.printf("------------------------------------------------------------------\n");
        System.out.printf("------------------------------------------------------------------\n\n");

        Scanner in = new Scanner(System.in);
        int pizzaNumber = 0;                 // Variable to store the number of the chosen pizza

        System.out.println("Enter the number of the pizza you want to order: ");

        while(pizzaNumber<1 || pizzaNumber>10){             // Input validation - Chosen number must be within scope

            if(in.hasNextInt()){                            // Input must be an integer
                pizzaNumber = in.nextInt();

                if(pizzaNumber<1 || pizzaNumber>10){
                    System.out.println("That pizza does not exist. Please try again: ");
                }
            }
            else{
                System.out.println("That pizza does not exist. Please try again: ");
                in.next();   // Reset input stream to allow new input
            }
        }

        String chosenPizza = "";       // Stores name of chosen pizza to use in receipt
        int pizzaPrice = 0;            // Stores price of chosen pizza to use in receipt

        if(pizzaNumber == 1){           // Assigning values to the chosenPizza and pizzaPrice
            chosenPizza = pizza1;
            pizzaPrice = pizza1Price;
        }
        else if(pizzaNumber == 2){
            chosenPizza = pizza2;
            pizzaPrice = pizza2Price;
        }
        else if(pizzaNumber == 3){
            chosenPizza = pizza3;
            pizzaPrice = pizza3Price;
        }
        else if(pizzaNumber == 4){
            chosenPizza = pizza4;
            pizzaPrice = pizza4Price;
        }
        else if(pizzaNumber == 5){
            chosenPizza = pizza5;
            pizzaPrice = pizza5Price;
        }
        else if(pizzaNumber == 6){
            chosenPizza = pizza6;
            pizzaPrice = pizza6Price;
        }
        else if(pizzaNumber == 7){
            chosenPizza = pizza7;
            pizzaPrice = pizza7Price;
        }
        else if(pizzaNumber == 8){
            chosenPizza = pizza8;
            pizzaPrice = pizza8Price;
        }
        else if(pizzaNumber == 9){
            chosenPizza = pizza9;
            pizzaPrice = pizza9Price;
        }
        else if(pizzaNumber == 10){
            chosenPizza = pizza10;
            pizzaPrice = pizza10Price;
        }

        choosePizzaSize(chosenPizza, pizzaPrice);    // Move on to pizzaSize method. Passing two variables to be used in receipt
    }

    public static void addToppingsPrintReciept(String chosenPizza, double newPrice, String chosenSize){

        String topping1 = "Peperoni";                    // Declares available toppings
        String topping2 = "Mozarella";
        String topping3 = "Mushroom";
        String topping4 = "Sausage";
        String topping5 = "Bacon";
        String topping6 = "Onion";
        String topping7 = "Ranch Dressing";

        System.out.println("-------------------- Add Toppings --------------------");    // Prints topping menu
        System.out.println("-------- Maximum 2 ------------------ 5 DKK each------");
        System.out.println("1. "+topping1);
        System.out.println("2. "+topping2);
        System.out.println("3. "+topping3);
        System.out.println("4. "+topping4);
        System.out.println("5. "+topping5);
        System.out.println("6. "+topping6);
        System.out.println("7. "+topping7);
        System.out.println("------------------------------------------------------\n");
        System.out.println("Enter the number of the topping you want to add: ");
        System.out.println("Enter a non number to order'");

        int toppingPrice = 0;          // Total price of toppings
        int toppingCount = 0;          // Number of toppings. loop must break if 2 toppings is chosen
        int chosenToppingNum = 0;      // Temporarily store number of chosen topping
        String chosenTopping1 = "";    // Stores name of toppings, so it can be passed to receipt
        String chosenTopping2 = "";

        Scanner in = new Scanner(System.in);

        while(toppingCount<2){

            while(chosenToppingNum>7 || chosenToppingNum<1){  //Loop continues as long as chosen number is not within scope

                if(in.hasNextInt()){                          //Checks that input is integer
                    chosenToppingNum = in.nextInt();

                    if(chosenToppingNum == 1){
                        chosenTopping1 = topping1;            //Store topping name to use in receipt
                        toppingCount++;                       //Increment number of toppings
                        toppingPrice += 5;                    //Increment total topping price
                    }
                    else if(chosenToppingNum == 2){
                        chosenTopping1 = topping2;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 3){
                        chosenTopping1 = topping2;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 4){
                        chosenTopping1 = topping4;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 5){
                        chosenTopping1 = topping5;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 6){
                        chosenTopping1 = topping6;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 7){
                        chosenTopping1 = topping7;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else System.out.println("That topping does not exist. Please try again");
                }
                else{
                    toppingCount = 2;
                    break;
                }
                }

            chosenToppingNum = 0;
            System.out.println("Now choose topping 2");

            while(chosenToppingNum>7 || chosenToppingNum<1){

                if(in.hasNextInt()){
                    chosenToppingNum = in.nextInt();

                    if(chosenToppingNum == 1){
                        chosenTopping2 = topping1;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 2){
                        chosenTopping2 = topping2;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 3){
                        chosenTopping2 = topping2;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 4){
                        chosenTopping2 = topping4;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 5){
                        chosenTopping2 = topping5;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 6){
                        chosenTopping2 = topping6;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else if(chosenToppingNum == 7){
                        chosenTopping2 = topping7;
                        toppingCount++;
                        toppingPrice += 5;
                    }
                    else System.out.println("That topping does not exist. Please try again");
                }
                else{
                    toppingCount = 2;
                    break;
                }
            }



        }

        double totalPrice = toppingPrice + newPrice;

        System.out.println("-----------------------------Receipt-----------------------------");     // Print out receipt
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%s\n",chosenPizza);
        System.out.println("Size:");
        System.out.println(chosenSize);
        System.out.printf("%-55s %.2f DKK\n\n","",newPrice);
        System.out.println("Topping(s):");
        System.out.printf("%s\n",chosenTopping1);
        System.out.printf("%s\n",chosenTopping2);
        System.out.printf("%-55s %.2f DKK\n\n","",(double)toppingPrice);
        System.out.printf("Total price: %48.2f DKK\n",totalPrice);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");

    }

    public static void choosePizzaSize(String chosenPizza,int pizzaPrice){

        int price = pizzaPrice;  // Used to calculate the price depending on the size

        String size1 ="Child", size2 ="Standard", size3 = "Family";

        System.out.println("-----------------------------------------");       // Print size menu
        System.out.println("---------------Choose size---------------");
        System.out.printf("1. %-20s Price DKK %.2f\n",size1,price*0.75);
        System.out.printf("2. %-20s Price DKK %.2f\n",size2,(double)price);
        System.out.printf("3. %-20s Price DKK %.2f\n",size3,price*1.5);
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------\n");

        System.out.println("Enter the number of the size you would like: ");
        Scanner in = new Scanner(System.in);
        int size = 0;

        while(size<1 || size>3){             // Input validation

            if(in.hasNextInt()){
                size = in.nextInt();

                if(size<1 || size>3){
                    System.out.println("That size does not exist. Please try again: ");
                }
            }
            else{
                System.out.println("That size does not exist. Please try again: ");
                in.next();   // Reset input stream to allow new input
            }
        }
        String chosenSize = "";
        double newPrice = 0;

        if(size == 1){
            chosenSize = size1;
            newPrice = price*0.75;
        }
        else if(size == 2){
            chosenSize = size2;
            newPrice = price;
        }
        else if(size == 3){
            chosenSize = size3;
            newPrice = price*1.5;
        }

        addToppingsPrintReciept(chosenPizza,newPrice,chosenSize);   // Go to next method and pass variables to be used in receipt
    }

}

