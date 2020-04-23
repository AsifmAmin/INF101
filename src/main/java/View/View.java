package View;

import Controller.InputOutputController;
import Interfaces.Input;
import Interfaces.Output;

import java.util.Scanner;

public class View implements Output {
    Scanner sc = new Scanner(System.in);

    /**
     * Implementation of the Output interface.  A method receives the code as a notification that makes it understand which kind of output it needs to do. It also receives output string from controller if it needs to output some special data determined by InputOutputController.
     * @param output
     * @param code
     */
    @Override
    public void doOutput(String output, String code) {
        //we need to print main menu
        if(code.equals("WELCOME"))
            printWelcomeMessage();
            //we need to print user input error and try again
        else if(code.equals("WELCOMEERROR"))
            printWelcomeErrorMessage();
            //we need to ask the user if he wants to play against computer or player
        else if(code.equals("INITIALIZEGAME"))
            printInitializeMessage();
            //we need to print user input error and try again
        else if(code.equals("INITIALIZEERROR"))
            printInitializeErrorMessage();
            //we need to ask user to do an input for a movement
        else if(code.equals("PLAYERONEMOVE"))
            printPlayerOneMovementMessage(output);
            //we need to notify user that he made an error in input and try again
        else if(code.equals("PLAYERONEMOVEERROR"))
            printPlayerOneMovementMessageError(output);
            //we need to ask second user to make a move
        else if(code.equals("PLAYERTWOMOVE"))
            printPlayerTwoMovementMessage(output);
            //we nee to notify second user that he made an error and try again
        else if(code.equals("PLAYERTWOMOVEEROR"))
            printPlayerTwoMovementMessageError(output);
            //we need to notify user that there is a winner found and ask him if he wants to play another game
        else if(code.equals("WINNERFOUND"))
            printWinnerFoundMessage(output);
            //we need to notify user that he made an error in input and try again
        else if(code.equals("ANOTHERGAMERESPONSEERROR"))
            printAnotherGameResponseError();
            //we need to notify user that there was a drawn game and ask him if he wants to play another game.
        else if(code.equals("DRAW"))
            printDrawMessage();
            //IF a game is Player vs computer we need to notify player about computer's move.
        else if(code.equals("COMPUTERMOVE"))
            printComputerMoveMessage(output);
    }

    /**
     * A method that outputs the movement of the computer
     * @param output
     */
    private void printComputerMoveMessage(String output) {
        System.out.println("Computer move: ");
        System.out.println(output);
        Input i = new InputOutputController();
        i.useInputData("", "COMPUTERMOVESHOWN");
    }

    /**
     * A method that prints a message that the game is drawn
     */
    private void printDrawMessage() {
        System.out.println("There are no empty spaces on the board. The game is draw!");
        printNewGameMenuMessage();
    }

    /**
     * A method that calls another methods that will display the user's input error and request another input for the another game choice.
     */
    private void printAnotherGameResponseError() {
        printInputErrormessage();
        printAnotherGameResponseError();
    }

    /**
     * A method that prints out a message that a player won the game and calls another method to ask for another game.
     */
    private void printWinnerFoundMessage(String output) {
        System.out.println(output + " won the game!");
        printNewGameMenuMessage();
    }

    /**
     * A method that prints out a menu and requires a user to make an input if he wants to play another game.
     */
    private void printNewGameMenuMessage(){
        System.out.println("Do you want to play another game, or return to the main menu?");
        System.out.println("1) Play another game");
        System.out.println("2) Back to main menu");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "ANOTHERGAMERESPONSE");
    }

    /**
     * A method that calls another methods that will display the second player's input error and request another input for the movement choice.
     */
    private void printPlayerTwoMovementMessageError(String output) {
        printInputErrormessage();
        printPlayerTwoMovementMessage(output);
    }

    /**
     * A method that prints out a current map state and requests from the second player to make an input for the movement.
     */
    private void printPlayerTwoMovementMessage(String output) {
        System.out.println(output);
        System.out.println("Player two move: ");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "PLAYERTWOMOVERESPONSE");
    }

    /**
     * A method that calls another methods that will display the first player's input error and request another input for the movement choice.
     */
    private void printPlayerOneMovementMessageError(String output) {
        printInputErrormessage();
        printPlayerOneMovementMessage(output);
    }

    /**
     * A method that prints out a current map state and requests from the first player to make an input for the movement.
     */
    private void printPlayerOneMovementMessage(String output) {
        System.out.println(output);
        System.out.println("Player one move: ");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "PLAYERONEMOVERESPONSE");
    }

    /**
     * A method that calls another methods that will display the user's input error and request another input for the game type choice.
     */
    private void printInitializeErrorMessage() {
        printInputErrormessage();
        printInitializeMessage();
    }

    /**
     * A method that prints out a menu to choose game type.
     */
    private void printInitializeMessage() {
        System.out.println("Your game starts. Who do you want to play against?");
        System.out.println("1) Another player");
        System.out.println("2) Computer");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "INITIALIZERESPONSE");
    }

    /**
     * A method that prints out wrong input message to the user. It is being called whenever a user made a wrong input in the application.
     */
    private void printInputErrormessage(){
        System.out.println("Wrong input! Please try again.");
    }

    /**
     * A method that calls another methods that will display the user's input error and request another input for the main menu choice.
     */
    private void printWelcomeErrorMessage() {
        printInputErrormessage();
        printWelcomeMessage();
    }

    /**
     * A method that prints out welcome message and main menu.
     */
    private void printWelcomeMessage() {
        System.out.println("Hello!");
        System.out.println("Please, choose the game you want to play:");
        System.out.println("1) Tic tac toe");
        System.out.println("2) Four in a row");
        System.out.println("3) Exit");
        String input = sc.nextLine();
        //Input interface is used to send input data with its own code back to InputOutputController.
        Input i = new InputOutputController();
        i.useInputData(input, "WELCOMERESPONSE");
    }
}
