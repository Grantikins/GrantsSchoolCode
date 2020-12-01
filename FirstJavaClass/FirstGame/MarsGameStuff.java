// This is a small Game that I made in my first ever Java course. The idea was to learn and reinforce our understanding of everything we learned up to that point in the semester
// which was Classes, Variables, APIs, Methods, Fundamentals of Objects, Conditional statements, Loops, and Print Statements
// The game is about an exploring space man crashing your rover on mars. You have to get to the space station by managing your character.


// This enables us to use the scanner object. It takes input from the terminal which is what we will be using
import java.util.Scanner;

// This is our most important class. It contains most of the logic in the game.
public class MarsGameStuff{

    // These are the main variables used in the game. Also our Scanner Object.
    private static int hunger, foodAmount, hungerDecrement;
    private static int suitCondition, materials, suitDecrement;
    private static int oxygenAmount, spareOxygen, oxygenDecrement;
    private static final int BEST_THRESHOLD = 80, GOOD_THRESHOLD = 50, BAD_THRESHOLD = 20, DIE_THRESHOLD = 0;
    private static int daysLeft;
    private static Scanner input = new Scanner(System.in);

    // This is a short intro to the game that will happen in the beginning of the game.
    public static void intro(){

        // set some random food(hunger), materials, oxygen, and daysleft variables
        foodAmount = (int)(Math.random() * 5) + 5;
        materials = (int)(Math.random() * 5) + 5;
        spareOxygen = (int)(Math.random() * 5) + 5;
        daysLeft = (int)(Math.random() * 5) + 28;
        
        System.out.println("*CRASH* *BANG*\nYou wake up in your rover just barely conscious. After a minute or two, you get out realizing the situation you're in. You take a look at the rover to analyze your situation." + 
        " An hour passes, and it is clear to you that the rover will not function. All of the attempts you made thus far to contact the terraforming company you work for have been for nothing." + 
        " The only way back is to walk back. You scavenge what's left on your rover to find:\nFood: " + foodAmount + "\nMaterials: " + materials + "\nSpare Oxygen: " + spareOxygen);
        System.out.println("You estimate that the time it will take you to get back to the main station is: " + daysLeft + " days");

        // sets the stats of your character
        hunger = 100;
        suitCondition = 100;
        oxygenAmount = 100;

        System.out.println("(Press Enter to continue)");
        input.nextLine();
    } 

    // A basic display to show the user what the condition of their character is
    public static void statDisplay(){

        System.out.println("**********" + daysLeft + "DAYS LEFT**********");
        System.out.println("**********STATS**********");
        if(hunger >= BEST_THRESHOLD){
            System.out.println("Hunger: Full"); 
        }
        else if(hunger < BEST_THRESHOLD && hunger >= GOOD_THRESHOLD){
            System.out.println("Hunger: Satisfied");
        }
        else if(hunger < GOOD_THRESHOLD && hunger >= BAD_THRESHOLD){
            System.out.println("Hunger: Hungry");
        }
        else{
            System.out.println("Hunger: Malnourished");
        }

        if(suitCondition >= BEST_THRESHOLD){
            System.out.println("Suit Condition: Pristine");
        }
        else if(suitCondition < BEST_THRESHOLD && suitCondition >= GOOD_THRESHOLD){
            System.out.println("Suit Condition: Good");
        }
        else if(suitCondition < GOOD_THRESHOLD && suitCondition >= BAD_THRESHOLD){
            System.out.println("Suit Condition: In Need of Repair");
        }
        else{
            System.out.println("Suit Condition: Badly Damaged");
        }

        if(oxygenAmount >= BEST_THRESHOLD){
            System.out.println("Oxygen Levels: High Concentration");
        }
        else if(oxygenAmount < BEST_THRESHOLD && oxygenAmount >= GOOD_THRESHOLD){
            System.out.println("Oxygen Levels: Average Concentration");
        }
        else if(oxygenAmount < GOOD_THRESHOLD && oxygenAmount >= BAD_THRESHOLD){
            System.out.println("Oxygen Levels: Low Concentration");
        }
        else{
            System.out.println("Oxygen Levels: Dangerously Low Concentration");
        }
        
    }

    // A display to show the supplies that the users character has.
    public static void supplyDisplay(){

        System.out.println("**********SUPPLIES**********");
        System.out.println("Food: " + foodAmount + 
        "\nMaterials: " + materials + 
        "\nSpare Oxygen: " + spareOxygen);
    }

    // This asks the usere what he/she wants to do reading through the Scanner
    public static int actions(){

        int choice;

        System.out.println("**********ACTIONS**********");
        System.out.println("What do you want to do?\n1) Eat some food\n2) Make suit repairs\n3) Refill some oxygen\n4) Walk an extra distance\n5) Search for supplies for a day");

        choice = input.nextInt();
        return choice;
    }

    // Method that takes in the users choice and does the logic associated with that choice.
    public static boolean actionConsequences(int chosenAction){

        switch(chosenAction){
           case 1:{
                if(foodAmount > 0){
                    foodAmount--;
                    hunger += 20;
                    if(hunger > 100){
                        hunger = 100;
                    }
                    return true;
                }
                else{
                    System.out.println("You don't have any food left! Choose Again.");
                    return false;
                }
            }
            case 2:{
                if(materials > 0){
                    materials--;
                    suitCondition += 20;
                    if(suitCondition > 100){
                        suitCondition = 100;
                    }
                    return true;
                }    
                else{
                    System.out.println("You don't have any materials left! Choose Again.");
                    return false;
                }
            }
            case 3:{
                if(spareOxygen > 0){
                    spareOxygen--;
                    oxygenAmount += 20;
                    if(oxygenAmount > 100){
                        oxygenAmount = 100;
                    }
                    return true;
                } 
                else{
                    System.out.println("You don't have any spare oxygen left! Choose Again.");
                    return false;
                }   
            }
            case 4:{
                hunger -= 10;
                suitCondition -= 10;
                daysLeft--;
                System.out.println("You walk an extra distance and reduce the amount of time it will take to get to the station by a day getting hungrier and damaging a bit of you suit in the process.");
                input.nextLine();
                input.nextLine();
                return true;
            }
            case 5:{
                System.out.println("You used the day to find supplies. (Press Enter)");
                daysLeft++;
                foodAmount += (int)(Math.random() * 5);
                materials += (int)(Math.random() * 5);
                spareOxygen += (int)(Math.random() * 5);
                input.nextLine();
                input.nextLine();
                return true;
            }
        }
        return false;
    }

    // This method is called at the end of the main loop to decrease the stats of the character.
    public static void decrements(){

        hungerDecrement = 10;
        suitDecrement = 10;
        oxygenDecrement = 10;

        hunger -= hungerDecrement;
        suitCondition -= suitDecrement;
        oxygenAmount -= oxygenDecrement;

        daysLeft--;

    }

    // Method to check and see if the player has won or lost.
    public static boolean loseConditions(){
        if(winConditions() == true){
            if(hunger <= DIE_THRESHOLD || suitCondition <= DIE_THRESHOLD || oxygenAmount <= DIE_THRESHOLD){
                if(hunger <= 0){
                    System.out.println("You died of starvation! (Press Enter)");
                }
                else if(suitCondition <= 0){
                    System.out.println("You died because your suit could not protect you from exposure to an uninhabitable environment! (Press Enter)");
                }
                else if(oxygenAmount <= 0){
                    System.out.println("You died of suffocation! (Press Enter)");
                }
                input.nextLine();
                MarsGraphics.deadGraphic();
                return false;
            }
            else{
                return true;
            }
        }
        if(winConditions() == false){
            return false;
        } 
        return true;   
    }

    // If the user's game has ended, it displays a prompt to see if the user wants to play again or not.
    public static boolean tryAgain(){

        int answer;
        System.out.println("Would you like to play again?\n1) Yes\n2) No");
        answer = input.nextInt();
        switch(answer){
            case 1:{
                return true;
            }
            case 2:{
                return false;
            }
        }
        return false;
    }
    
    // Clears the terminal
    public static void clear(){

        System.out.println("\033[H\033[2J");
    }

    // A method that decides based on a random number if an event happens and then does event logic if there is an event happening.
    public static void eventHappening(){

        double chanceForEvent = Math.random();
        double eventDecider = Math.random();
        int choice;

        if(chanceForEvent <= .15){
            System.out.println("**********SCAVENGING EVENT**********");
            if(eventDecider <= .33){
                MarsGraphics.stationGraphic();
                System.out.println("You found an old abandoned mining station. It seems to date back to the year 2053. Although it's old, you can probably find something useful in there.");
                System.out.println("Do you want to spend the day and check it out?\n1) Yes\n2) No");
                choice = input.nextInt();

                switch(choice){
                    case 1:{
                        daysLeft++;
                        hunger += 22;
                        oxygenAmount += 22;
                        suitCondition += 22;
                        System.out.println("You find the necessary rooms and refill some of your hunger, oxygen, and repair your suit some. (Press Enter)");
                        input.nextLine();
                        input.nextLine();
                    }break;
                    default:{
                        break;
                    }
                }
            }

            else if(eventDecider > .33 && eventDecider <= .66){
                MarsGraphics.roverGraphic();
                System.out.println("You found an old and destroyed rover. It likely has some useful supplies still in it.");
                System.out.println("Do you want to spend the day looking inside of it?\n1) Yes\n2) No");
                choice = input.nextInt();

                switch(choice){
                    case 1:{
                        daysLeft++;
                        hunger += 12;
                        oxygenAmount += 12;
                        suitCondition += 12;
                        foodAmount += 3;
                        spareOxygen += 3;
                        materials += 3;
                        System.out.println("You find some supplies, and refill your hunger, oxygen, and suit condition. (Press Enter)");
                        input.nextLine();
                        input.nextLine();
                    }break;
                    default:{
                        break;
                    }
                }
            }

            else {
                MarsGraphics.droneGraphic();
                System.out.println("A drone approaches you. It is clearly one from your terraforming station. It brings some info about the lay of the land and instructs you to move in a certain direction" + 
                " reducing the time it was going to take to get back to the station by an extra two days. (Press Enter)");
                daysLeft -= 2;
                input.nextLine();
                input.nextLine();
            }
        }
        
    }

    // Determines if the user has won or not.
    public static boolean winConditions(){

        if(daysLeft <= 1){
            return false;
        }
        else{
            return true;
        }
    }
}