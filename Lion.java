import java.util.*;

/*
Pre: N/A
What it does: The class Lion is the subclass of the animal method and it contains the methods/functions that run the program
Post: N/A
 */
public class Lion extends Animal {
    int food;
    int water;
    int warmth;
    int health;
    int lifelines;

    /*
    Pre: N/A
    What it does: This is the constructor of the Lion class and it gives an initial value to the variable members
    Post: N/A
     */
    public Lion() {
        food = 0;
        water = 0;
        warmth = 0;
        health = 0;
        lifelines = 0;
    }

    /*
    Pre: N/A
    What it does: This is the parameterized constructor and it initializes the variables with a value that have
    been passed as a parameter to the Lion class.
    Post: N/A
     */
    public Lion(int initialFood, int initialWater, int initialWarmth, int initialHealth, int initialLifelines) {
        food = initialFood;
        water = initialWater;
        warmth = initialWarmth;
        health = initialHealth;
        lifelines = initialLifelines;
    }

    /*
    Pre: It takes the food variable from the main method as parameter
    What it does:  It sets the value of the variable food
    Post: N/A
     */
    public void setFood(int initialFood){
        food = initialFood;
    }

    /*
    Pre: It takes the water variable from the main method as parameter
    What it does:  It sets the value of the variable water
    Post: N/A
     */
    public void setWater(int initialWater){
        water = initialWater;
    }

    /*
    Pre: It takes the warmth variable from the main method as parameter
    What it does:  It sets the value of the variable warmth
    Post: N/A
     */
    public void setWarmth(int initialWarmth){
        warmth = initialWarmth;
    }

    /*
    Pre: It takes the health variable from the main method as parameter
    What it does:  It sets the value of the variable health
    Post: N/A
     */
    public void setHealth(int initialHealth){
        health = initialHealth;
    }

    /*
    Pre: It takes the lifeLines variable from the main method as parameter
    What it does:  It sets the value of the variable lifeLines
    Post: N/A
     */
    public void setLifelines(int initialLifelines) {
        lifelines = initialLifelines;
    }

    /*
    Pre: N/A
    What it does:  It returns the value of the variable food
    Post: The value of the variable food is returned
     */
    public int getFood() {
        return food;
    }

    /*
    Pre: N/A
    What it does:  It returns the value of the variable water
    Post: The value of the variable water is returned
     */
    public int getWater() {
        return water;
    }

    /*
    Pre: N/A
    What it does:  It returns the value of the variable warmth
    Post: The value of the variable warmth is returned
     */
    public int getWarmth() {
        return warmth;
    }

    /*
    Pre: N/A
    What it does:  It returns the value of the variable health
    Post: The value of the variable health is returned
     */
    public int getHealth(){
        return health;
    }

    /*
    Pre: N/A
    What it does:  It returns the value of the variable lifeLines
    Post: The value of the variable lifeLines is returned
     */
    public int getLifelines() {
        return lifelines;
    }

    /*
    Pre: N/A
    What it does:  The method directs and organizes the game, and all of the methods in the subclass
    Post: N/A
     */
    public void Menu() {
        Scanner input = new Scanner(System.in);
        //the animal stats are printed to the console
        System.out.println(toString());
        System.out.println("");
        //the user is asked what they would like to do and need to pick an option
        System.out.println("What would you like to do?");
        System.out.println("1 - Hunt for food");
        System.out.println("2 - Search for water");
        System.out.println("3 - Find Shelter");
        System.out.println("4 - Rest");
        // if the user has a lifeline, then this will be printed
        if (lifelines > 0){
            System.out.println("5 - Use lifeline");
        }
        System.out.println("Choice: ");
        int choice = input.nextInt();

        //depending on the value entered by the user the program will enter one of the conditional statements
        if (choice == 1) {
            //the user chooses to hunt for food
            System.out.println(findFood(choice));
            //the values of the other variables are decreased
            findWater(choice);
            findWarmth(choice);
            getRest(choice);
        } else if (choice == 2) {
            //the user chooses to search for water
            System.out.println(findWater(choice));
            //the values of the other variables are decreased
            findFood(choice);
            findWarmth(choice);
            getRest(choice);
        } else if (choice == 3){
            //the user chooses to search for warmth
            System.out.println(findWarmth(choice));
            //the values of the other variables are decreased
            findWater(choice);
            findFood(choice);
            getRest(choice);
        }else if (choice == 4){
            //the user chooses to get rest
            System.out.println(getRest(choice));
            //the values of the other variables are decreased
            findWarmth(choice);
            findWater(choice);
            findFood(choice);
        }else{
            //choice == 5;
            //user decides to use a lifeline

            useLifeline();
        }
    }

    /*
    Pre: N/A
    What it does: It returns a string with the status of the variables
    Post: This method returns a string with the status of the variables
     */
    public String toString() {
        return "Animal: Lion\n" + "Hunger: " + food + "/25\n" + "Thirst: " + water + "/25\n" + "Warmth: " + warmth + "/25\n" + "Health: " + health + "/25\n";
    }

    /*
    Pre: It takes the variable choice from the menu method as a parameter
    What it does: It generates a random number, and either adds/subtracts the points of food
    Post:  A string with the information of what happened is returned
     */
    public String findFood(int choice) {
        if (choice == 1){
            Random random = new Random();
            int number = random.nextInt(-4, 11);
            if ((food + number) <= 25 && (food + number) >= 0){
                if (number > 0) {
                    if (number == 1){
                        //random good event
                        int remainingValue = 25 - food;
                        food = food + remainingValue;
                        return "You found a buffet! Hunger has been completely restored";
                    }else if(number == 2){
                        //random bad event
                        setFood(1);
                        return "You got attacked and all your energy was used up, hunger is extremely low!";
                    }else{
                        // in all other cases
                        food = food + number;
                        return "Your hunger has been replenished by " + number + " points ";
                    }

                }else{
                    //if number is a negative number or zero, then food is not found
                    if ((food + number) >= 0){
                        food = food + number;
                        return "Food could not be found";
                    }else{
                        return "";
                    }
                }
            }else{
                //if food has already reached maximum nothing is done
                return "";
            }

        }else{
            //decrease value of hunger while it is not being called on
            Random random = new Random();
            int number = random.nextInt(5) + 1;
            if ((food - number >= 0)){
                food = food - number;
                return "";
            }else{
                return "";
            }
        }
    }

    /*
    Pre: It takes the variable choice from the menu method as a parameter
    What it does: It generates a random number, and either adds/subtracts the points of water
    Post:  A string with the information of what happened is returned
     */
    public String findWater(int choice) {
        if (choice == 2){
            Random random = new Random();
            int number = random.nextInt(-4 , 11);
            if ((water + number) <= 25 && (water + number) >= 0){
                if (number > 0) {
                    if (number == 1){
                        //random good event
                        int remainingValue = 25 - water;
                        water = water + remainingValue;
                        return "You found a lake! Thirst levels completely restored!";
                    }else if (number == 2){
                        //random bad event
                        setWater(1);
                        return "You got attacked and all your energy was used up, thirst is extremely low!";
                    }else{
                        //normal events
                        water = water + number;
                        return "You found a puddle! Your thirst has been replenished by " + number + " points ";
                    }
                }else{
                    //if number is zero or negative
                    if ((water + number) >= 0){
                        water = water + number;
                        return "Water could not be found";
                    }else{
                        return "";
                    }

                }
            }else{
                //is water has reached maximum then nothing should be done
                return "";
            }

        }else{
            //decrease value of water while it is not being called on
            Random random = new Random();
            int number = random.nextInt(5) + 1;
            if ((water - number >= 0)){
                water = water - number;
                return "";
            }else{
                return "";
            }

        }

    }

    /*
    Pre: It takes the variable choice from the menu method as a parameter
    What it does: It generates a random number, and either adds/subtracts the points of warmth
    Post:  A string with the information of what happened is returned
     */
    public String findWarmth(int choice) {
        if (choice == 3){
            Random random = new Random();
            int number = random.nextInt(-4, 11);
            if ((warmth + number) <= 25  && (warmth + number) >= 0){
                if (number > 0) {
                    if (number == 1){
                        //random good event
                        int remainingValue = 25 - warmth;
                        warmth = warmth + remainingValue;
                        return "You found a sauna! Warmth has been completely restored!";
                    }else if (number == 2){
                        //random bad event
                        setWarmth(1);
                        return "You got attacked and all your energy was used up, warmth is extremely low!";
                    }else{
                        //normal cases
                        warmth = warmth + number;
                        return "You found a fire pit! Your warmth has been replenished by " + number + " points ";
                    }
                }else{
                    //if number is a negative number of equal to zero
                    if ((warmth + number) >= 0){
                        warmth = warmth + number;
                        return "Shelter could not be found";
                    }else{
                        return "";
                    }

                }
            }else{
                //if warmth has reached its maximum value
                return "";
            }

        }else{
            //decrease value of warmth while it is not being called on
            Random random = new Random();
            int number = random.nextInt(5) + 1;
            if ((warmth - number >= 0)){
                warmth = warmth - number;
                return "";
            }else{
                return "";
            }
        }

    }

    /*
    Pre: It takes the variable choice from the menu method as a parameter
    What it does: It generates a random number, and either adds/subtracts the points of health
    Post:  A string with the information of what happened is returned
     */
    public String getRest(int choice) {
        if (choice == 4){
            //user chooses to rest
            Random random = new Random();
            int number = random.nextInt(-4, 11);

            if ((health + number) <= 25 && (health + number) >= 0){
                if (number == 1){
                    //random good event
                    int remainingValue = 25 - health;
                    health = health + remainingValue;
                    return "You found a house and got full rest! Health has been completely restored!";
                }else if (number == 2){
                    //random bad event
                    setHealth(1);
                    return "You got attacked and all your energy was used up, health is extremely low!";
                }else if (number == 3){
                    //special health random bad event
                    return "Predators near by, did not get to rest";
                }else if (number == 4){
                    //special health random good event
                    health = health + 2;
                    return "Predators at far distance, got some rest and health has been replenished by 2 points";
                }else{
                    //special health random good event
                    health = health + 5;
                    return "No predators in area, well rested and health has been replenished by 5 points";
                }
            }else{
                //if warmth has reached its maximum value
                return "";
            }


        }else{
            //if they do not choose to rest, health goes down
            Random random = new Random();
            int number = random.nextInt(3) + 1;
            if (number == 1){
                // very minor injuries
                if ((health - 1) >= 0){
                    health = health -1;
                    return "";
                }else{
                    return "";
                }
            } else if (number == 2){
                //minor injuries
                if ((health - 2 >= 0)){
                    health = health - 2;
                    return "";
                }else{
                    return "";
                }

            }else{
                //major injuries
                if ((health -5) >= 0){
                    health = health - 5;
                    return "";
                }else{
                    return "";
                }
            }
        }

    }

    /*
    Pre: N/A
    What it does: It asks the user which variable they would like to increase, and correspondingly increases that
    variable by a value of 5
    Post:  N/A
     */
    public void useLifeline(){
        Scanner input = new Scanner(System.in);
        //user is asked which variable they would like to increase
        System.out.println("Would you like to use the lifeline to increase: ");
        System.out.println("1 - Hunger");
        System.out.println("2 - Thirst");
        System.out.println("3 - Warmth");
        System.out.println("4 - Health");
        int lifelineChoice = input.nextInt();

        /*program enters a while statement based on the choice entered, increased that specific variable by 5, and
        lets the user know that that specific variable has been increased by 5 points
         */
        if (lifelineChoice == 1){
            food = food + 5;
            System.out.println("Hunger levels have been increased by 5 points");
        }else if (lifelineChoice == 2){
            water = water + 5;
            System.out.println("Thirst levels have been increased by 5 points");
        }else if (lifelineChoice == 3){
            warmth = warmth + 5;
            System.out.println("Warmth levels have been increased by 5 points");
        }else{
            health = health + 5;
            System.out.println("Health levels have been increased by 5 points");
        }
        //the number of lifelines is set to 0
        setLifelines(0);
        //user is told that the lifeline has been used
        System.out.println("Lifeline has been used");
    }
}
