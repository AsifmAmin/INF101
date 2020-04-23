package View;

import Controller.InputOutputController;
import Interfaces.Input;
import Interfaces.Output;

import java.util.Scanner;

public class View implements Output {
    Scanner sc = new Scanner(System.in);

    //Implementation of Output interface. here are notifications from InputOUtputController coming.
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

    private void printComputerMoveMessage(String output) {
        System.out.println("Computer move: ");
        System.out.println(output);
        Input i = new InputOutputController();
        i.useInputData("", "COMPUTERMOVESHOWN");
    }

    private void printDrawMessage() {
        System.out.println("There are no empty spaces on the board. The game is draw!");
        printNewGameMenuMessage();
    }

    private void printAnotherGameResponseError() {
        printInputErrormessage();
        printAnotherGameResponseError();
    }

    private void printWinnerFoundMessage(String output) {
        System.out.println(output + " won the game!");
        printNewGameMenuMessage();
    }

    private void printNewGameMenuMessage(){
        System.out.println("Do you want to play another game, or return to the main menu?");
        System.out.println("1) Play another game");
        System.out.println("2) Back to main menu");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "ANOTHERGAMERESPONSE");
    }

    private void printPlayerTwoMovementMessageError(String output) {
        printInputErrormessage();
        printPlayerTwoMovementMessage(output);
    }

    private void printPlayerTwoMovementMessage(String output) {
        System.out.println(output);
        System.out.println("Player two move: ");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "PLAYERTWOMOVERESPONSE");
    }

    private void printPlayerOneMovementMessageError(String output) {
        printInputErrormessage();
        printPlayerOneMovementMessage(output);
    }

    private void printPlayerOneMovementMessage(String output) {
        System.out.println(output);
        System.out.println("Player one move: ");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "PLAYERONEMOVERESPONSE");
    }

    private void printInitializeErrorMessage() {
        printInputErrormessage();
        printInitializeMessage();
    }

    private void printInitializeMessage() {
        System.out.println("Your game starts. Who do you want to play against?");
        System.out.println("1) Another player");
        System.out.println("2) Computer");
        String input = sc.nextLine();
        Input i = new InputOutputController();
        i.useInputData(input, "INITIALIZERESPONSE");
    }

    private void printInputErrormessage(){
        System.out.println("Wrong input! Please try again.");
    }

    private void printWelcomeErrorMessage() {
        printInputErrormessage();
        printWelcomeMessage();
    }

    //print welcome message and main menu.
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
