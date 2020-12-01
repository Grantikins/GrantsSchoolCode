import java.util.Scanner;

// This is the main method wi the main game loop. This file will be the file that is run.
public class Mars{

    public static void main(String[] args){ 

        boolean tryAgain = false;
        Scanner input = new Scanner(System.in);

        MarsGameStuff.clear();
        do{
            MarsGameStuff.intro();
            MarsGameStuff.clear();
            gameLoop();
            if(MarsGameStuff.winConditions() == false){
                System.out.println("You made it! You got back to the terraforming station safely! Congratulations! (Press Enter)");
                MarsGraphics.winGraphic();
                input.nextLine();
            }
            tryAgain = MarsGameStuff.tryAgain();
        }while(tryAgain == true);

    }

    // The main game loop that uses all of the MarsGameStuff methods.
    public static void gameLoop(){

        boolean playing = true;
        int chosenAction;
        boolean finishAction;

        do{
            MarsGameStuff.statDisplay();
            MarsGameStuff.supplyDisplay();
            do{
                chosenAction = MarsGameStuff.actions();
                finishAction = MarsGameStuff.actionConsequences(chosenAction);
            }while(finishAction == false);
            MarsGameStuff.clear(); 
            MarsGameStuff.statDisplay();
            MarsGameStuff.supplyDisplay();  
            MarsGameStuff.eventHappening();
            MarsGameStuff.clear();
            MarsGameStuff.decrements();
            playing = MarsGameStuff.winConditions();
            playing = MarsGameStuff.loseConditions();
        }while(playing == true);
    }

}