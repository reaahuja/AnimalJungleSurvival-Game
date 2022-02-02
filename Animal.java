// Author: Rea Ahuja
// Date: November 11th 2021
/* Description: This program is a game called animal survival, where the user can choose to be a specific animal
and choose to perform specific actions in order to continue playing (for their animal to survive)
 */
import java.util.*;

//Animal is an abstract class and is the super class for the lion, elephant, giraffe and deer subclasses
abstract public class Animal {
    /*
    Pre: N/A
    What it does: This method is the constructor of the Animal class
    Post: N/A
     */
    public Animal(){};
    /*
    Pre: N/A
    What it does: It is an abstract method
    Post: N/A
     */
    abstract void Menu();
    /*
   Pre: It takes the choice variable as a parameter
   What it does: It is an abstract method
   Post: N/A
    */
    abstract String findFood(int choice);
    /*
   Pre: It takes the choice variable as a parameter
   What it does: It is an abstract method
   Post: N/A
    */
    abstract String findWater(int choice);
    /*
   Pre: It takes the choice variable as a parameter
   What it does: It is an abstract method
   Post: N/A
    */
    abstract String findWarmth(int choice);
    /*
   Pre: It takes the choice variable as a parameter
   What it does: It is an abstract method
   Post: N/A
    */
    abstract String getRest(int choice);
    /*
   Pre: N/A
   What it does: It is an abstract method
   Post: N/A
    */
    abstract int getFood();
    /*
   Pre: N/A
   What it does: It is an abstract method
   Post: N/A
    */
    abstract int getWater();
    /*
   Pre: N/A
   What it does: It is an abstract method
   Post: N/A
    */
    abstract int getWarmth();
    /*
   Pre: N/A
   What it does: It is an abstract method
   Post: N/A
    */
    abstract int getHealth();
    /*
   Pre: It takes the initialLifelines variable as a parameter
   What it does: It is an abstract method
   Post: N/A
    */
    abstract void setLifelines(int initialLifelines);


}

/*
Pre: The animal class must be declared
What it does: This class contains the main method which is the driver code. Thereby it directs the user and program.
Post: N/A
 */
class ClientCode {

    /*
    Pre:N/A
    What it does: This method directs the program and the user
    Post:N/A
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        boolean chosen;
        Animal animalType;

        //user is given instructions for the game
        instructions();
        //user is asked for choice on type of animal
        System.out.println("Choice: ");
        int choice = input.nextInt();

        //method overriding is used to confirm that user imputed a valid choice
        if (choice!= 1 && choice != 2 && choice != 3 && choice != 4){
            chosen = false;
            //2 parameters are passed to chosenAnimal method
            choice = chosenAnimal(chosen, choice);
        }else{
            chosen = true;
            //1 parameter is passed to chosenAnimal method
            int extra = chosenAnimal(chosen);
        }



        //variables are assigned initial value
        int food = assignPoints(choice);
        int water = assignPoints(choice);
        int warmth = assignPoints(choice);
        int health = assignPoints(choice);
        int lifeLines = 1;

        //program enters conditional statement based on choice entered by user
        if (choice == 1){
            //user chooses to be a lion
            animalType = new Lion(food, water, warmth, health, lifeLines);

        }else if (choice == 2){
            //user chooses to be a elephant
            animalType = new Elephant(food, water, warmth, health, lifeLines);
        }else if (choice == 3){
            //user chooses to be a giraffe
            animalType = new Giraffe(food, water, warmth, health, lifeLines);
        }else{ // choice == 4
            //user chooses to be a deer
            animalType = new Deer(food, water, warmth, health, lifeLines);
        }


        //while loop runs until one of the variables reaches 0
        while (animalType.getFood() > 0 && animalType.getWater() > 0 && animalType.getWarmth() > 0 && animalType.getHealth() > 0){
            i = i +1;
            System.out.println("Day " + i + ":");
            animalType.Menu();
            System.out.println("");

            //user is given positive prompt based on type of animal
            if (choice == 1){
                //user is a lion
                System.out.println( positivePromptsLion(i));

            }else if (choice == 2){
                //user is a elephant
                System.out.println(positivePromptsElephant(i));

            }else if (choice == 3){
                //user is a giraffe
                System.out.println(positivePromptsGiraffe(i));
            }else{
                //user is a deer
                System.out.println(positivePromptsDeer(i));
            }
            System.out.println("");



            //every 20 days, the number of lifelines is reset to a value of 1
            if (i%20 == 0){
                if(i == 20){
                    firstWizardEncounter();
                    animalType.setLifelines(1);
                }else{
                    continuousWizardEncounter();
                    animalType.setLifelines(1);
                }


            }


        }
        //program exits while loop once one of the variables is equal to 0 and the animal dies

        //user is given stats on animal
        System.out.println(animalType.toString());

        //user is told how they have died
        if (animalType.getFood() <= 0){
            System.out.println("You have died from hunger!");
        }else if (animalType.getWater() <= 0){
            System.out.println("You have died from thirst!");
        }else if (animalType.getWarmth() <= 0){
            System.out.println("You have died from the cold!");
        }else{
            System.out.println("You have died from injuries!");
        }

        //user is told how many days they have survived for
        System.out.println("You survived for " + i + " days");

        //user is told that the program comes to an end
        System.out.println("Program ends");

    }

    /*
    Pre: N/A
    What it does: This program gives the user instructions on how to play the game and allows them to see the different
    types of animal that they can choose from. Thereby, the program prints the instructions and the types of animals
    to the console
    Post: N/A
     */
    public static void instructions(){
        System.out.println("Welcome to the animal survival game!");
        System.out.println("\nInstructions:");
        System.out.println("To play you must choose an animal and then choose one of the actions in the menu");
        System.out.println("In the menu you have the option to hunt for food, search for water, find shelter, rest or use a lifeline");
        System.out.println("You only have 1 initial lifeline, and it will increase either hunger/thirst/warmth/health levels by 5 points");
        System.out.println("You will need to keep your hunger, thirst, and warmth levels high enough to survive!");
        System.out.println("\nChoose one of the following animals to play as.");
        System.out.println("Who would you like to play as?");
        System.out.println("1 - Lion");
        System.out.println("2-  Elephant");
        System.out.println("3 - Giraffe");
        System.out.println("4 - Deer");
    }

    /*
    Pre: The program takes the choice imputed by the user in the main method as a parameter
    What it does: It generates a random number in a range dependent on the user's animal choice
    Post: The number generated is returned
     */
    public static int assignPoints(int choice){
        Random random = new Random();

        if (choice == 1){
            //user chooses to be a lion
            // max points: 25
            int number = random.nextInt(25) + 1;
            return number;
        }else if (choice == 2){
            //user chooses to be a elephant
            //max points: 20
            int number = random.nextInt(20) + 1;
            return number;
        }else if (choice == 3){
            //user chooses to be a giraffe
            //max points: 15
            int number = random.nextInt(15) + 1;
            return number;
        }else{
            //user chooses to be a deer
            //max points: 10
            int number = random.nextInt(10) + 1;
            return number;
        }

    }

    /*
    Pre: The method takes the number of days that have passed in the game as a parameter
    What it does: It returns a positive prompt based on which day it is
    Post: A string that contains a positive prompt is returned
     */
    public static String positivePromptsLion(int i){
        if (i == 5){
            return "Congratulations! You are head of your lion pack!";
        }else if (i == 10){
            return "Congratulations! You are the strongest lion in your region!";
        }else if (i == 15){
            return "Congratulations! You are the strongest lion in the entire jungle!";
        }else if (i == 20){
            return "Congratulations! You are now the ruler of the jungle";
        }else if (i%20 == 0){
            return "Congratulations! No one can take your stance, you are still the ruler of the jungle!";
        }else{
            return "";
        }
    }

    /*
    Pre: The method takes the number of days that have passed in the game as a parameter
    What it does: It returns a positive prompt based on which day it is
    Post: A string that contains a positive prompt is returned
     */
    public static String positivePromptsGiraffe(int i){
        if (i == 5){
            return "Congratulations! You are head of your giraffe pack!";
        }else if (i == 10){
            return "Congratulations! You are the strongest giraffe in your region!";
        }else if (i == 15){
            return "Congratulations! You are the strongest giraffe in the entire jungle!";
        }else if (i == 20){
            return "Congratulations! You are now the ruler of the jungle";
        }else if (i%20 == 0){
            return "Congratulations! No one can take your stance, you are still the ruler of the jungle!";
        }else{
            return "";
        }
    }

    /*
    Pre: The method takes the number of days that have passed in the game as a parameter
    What it does: It returns a positive prompt based on which day it is
    Post: A string that contains a positive prompt is returned
     */
    public static String positivePromptsDeer(int i){
        if (i == 5){
            return "Congratulations! You are head of your deer pack!";
        }else if (i == 10){
            return "Congratulations! You are the strongest deer in your region!";
        }else if (i == 15){
            return "Congratulations! You are the strongest deer in the entire jungle!";
        }else if (i == 20){
            return "Congratulations! You are now the ruler of the jungle";
        }else if (i%20 == 0){
            return "Congratulations! No one can take your stance, you are still the ruler of the jungle!";
        }else{
            return "";
        }
    }

    /*
    Pre: The method takes the number of days that have passed in the game as a parameter
    What it does: It returns a positive prompt based on which day it is
    Post: A string that contains a positive prompt is returned
     */
    public static String positivePromptsElephant(int i){
        if (i == 5){
            return "Congratulations! You are head of your elephant pack!";
        }else if (i == 10){
            return "Congratulations! You are the strongest elephant in your region!";
        }else if (i == 15){
            return "Congratulations! You are the strongest elephant in the entire jungle!";
        }else if (i == 20){
            return "Congratulations! You are now the ruler of the jungle";
        }else if (i%20 == 0){
            return "Congratulations! No one can take your stance, you are still the ruler of the jungle!";
        }else{
            return "";
        }
    }

    /*
    Pre: N/A
    What it does: The method prints a story to the console. Specifically a story that introduces the wizards house
    and the concept of the lifelines being reset every 20 days
    Post: N/A
     */
    public static void firstWizardEncounter(){
        System.out.println("What's this? It looks like you have encountered a wizard's house");
        System.out.println("You decide to walk inside and there is a table with a bright blue globe on it");
        System.out.println("You touch the bright blue globe, and glitter explodes from it!");
        System.out.println("Congratulations, you now have 1 lifeline in total!");
    }

    /*
    Pre: N/A
    What it does: The method prints the information to the user that the number of lifelines is being reset to 1.
    Post: N/A
     */
    public static void continuousWizardEncounter(){
        System.out.println("What's this? It looks like you have encountered the wizard's house again");
        System.out.println("You walk inside and there is a bright blue globe on the table again");
        System.out.println("You touch the bright blue globe, and glitter explodes from it!");
        System.out.println("Congratulations, you now have 1 lifeline in total!");
    }

    /*
    Pre: It takes the boolean variable chosen and the integer variable choice as parameters
    What it does: It makes the user choose a valid option for the type of animal that they would like to play as
    Post: It returns the numeric option for the type of animal that the user would like to use
     */
    public static int chosenAnimal(boolean chosen, int choice){
        Scanner input = new Scanner(System.in);
        //user is told that their option was incorrect and are told to choose an option again
        System.out.println("Chosen is " + chosen + " thereby you have chosen an invalid option");
        System.out.println("Choose again");
        //user is given menu again
        System.out.println(" 1 - Lion \n 2 - Elephant \n 3 - Giraffe \n 4 - Deer");
        choice = input.nextInt();

        //program enters while loop if the user enters an invalid option
        //while loop continues until user enters a valid option
        while (choice != 1 && choice != 2 && choice != 3 && choice != 4){
            System.out.println("You have chosen an invalid option");
            System.out.println("Choose again");
            System.out.println(" 1 - Lion \n 2 - Elephant \n 3 - Giraffe \n 4 - Deer");
            choice = input.nextInt();
        }
        /*once program exits the while loop, chosen is set to true, the method is called on with the chosen parameter
        set to true to tell user that their choice is valid
         */
        chosen = true;
        chosenAnimal(chosen);
        //the user's numeric choice of the type of animal they would like to play as is returned
        return choice;
    }

    /*
    Pre: It takes the boolean variable chosen as a parameter
    What it does: It lets the user know that their choice is valid
    Post: It returns the value 0
     */
    public static int chosenAnimal(boolean chosen){
        System.out.println("Choice is " + chosen + " thereby valid");
        System.out.println("");
        return 0;
    }
}








