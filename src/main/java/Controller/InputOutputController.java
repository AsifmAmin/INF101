package Controller;

import Enums.GameName;
import Enums.GameType;
import Interfaces.Input;
import Interfaces.Output;
import Model.GameModel;
import View.View;

public class InputOutputController implements Input {
    GameController g;

    /**
     * A method that is first used to notify a view to display welcome message and main menu.
     */
    public void welcomeMessage(){
        Output o = new View();
        o.doOutput("", "WELCOME");
    }

    /**
     * A method that handles user's input from the view regarding the decision of playing another game. After handling the input notifies the view about result.
     * @param input
     */
    private void handleAnotherGameResponse(String input) {
        if(input.equals("1")){
            if(GameModel.getInstance().gameName == GameName.TicTacToe)
                startTicTacToeGame();
            else
                startFourInRowGame();
        }
        else if(input.equals("2"))
            welcomeMessage();
        else{
            Output o = new View();
            o.doOutput("", "ANOTHERGAMERESPONSEERROR");
        }
    }

    /**
     * A method that handles user's input from the view regarding the second player's movement input. After handling the input notifies the view about result.
     * @param input
     */
    private void handlePlayerTwoMoveResponse(String input) {
        try{
            String[] splitInput = input.split(",");
            splitInput[0] = splitInput[0].replace(",", "");
            splitInput[0] = splitInput[0].replace(" ", "");
            splitInput[1] = splitInput[1].replace(",", "");
            splitInput[1] = splitInput[1].replace(" ", "");
            int moveX = Integer.parseInt(splitInput[0]);
            int moveY = Integer.parseInt(splitInput[1]);
            //if movements are parsed well, then it is valid input. Now we need to check if the coordinates are valid
            if(GameModel.getInstance().gameName == GameName.TicTacToe) {
                g = new TicTacToeController();
            }
            else
                g = new FourInRowController();
            if(g.checkIfMoveValid(moveY, moveX)){
                //coordinates are valid
                g.addPlayerTwoMovement(moveY, moveX);
                g.setMovementOnMap(moveY, moveX);
                //check if movement is victorious
                if(g.checkForVictory()){
                    Output o = new View();
                    o.doOutput(g.getVictoryPlayerName(), "WINNERFOUND");
                }
                //check if map is full - draw
                else if(g.checkIfMapFull()){
                    Output o = new View();
                    o.doOutput("", "DRAW");
                }
                //no victories, no draws, game continues with another player.
                else{
                    g.setPlayerOneTurn();
                    Output o = new View();
                    o.doOutput(g.getMapAsString(), "PLAYERONEMOVE");
                }
            }
            else{
                Output o = new View();
                o.doOutput(g.getMapAsString(), "PLAYERTWOMOVEEROR");
            }
        }catch(Exception ex){
            //Invalid input happened
            Output o = new View();
            if(GameModel.getInstance().gameName == GameName.TicTacToe){
                g = new TicTacToeController();
                o.doOutput(g.getMapAsString(), "PLAYERTWOMOVEEROR");
            }
            else{
                g = new FourInRowController();
                o.doOutput(g.getMapAsString(), "PLAYERTWOMOVEEROR");
            }
        }
    }

    /**
     * A method that handles user's input from the view regarding the first player's movement input. After handling the input notifies the view about result.
     * @param input
     */
    private void handlePlayerOneMoveResponse(String input) {
        try{
            String[] splitInput = input.split(",");
            splitInput[0] = splitInput[0].replace(",", "");
            splitInput[0] = splitInput[0].replace(" ", "");
            splitInput[1] = splitInput[1].replace(",", "");
            splitInput[1] = splitInput[1].replace(" ", "");
            int moveX = Integer.parseInt(splitInput[0]);
            int moveY = Integer.parseInt(splitInput[1]);
            if(GameModel.getInstance().gameName == GameName.TicTacToe)
                g = new TicTacToeController();
            else
                g = new FourInRowController();
            if(g.checkIfMoveValid(moveY, moveX)){
                g.addPlayerOneMovement(moveY, moveX);
                g.setMovementOnMap(moveY, moveX);
                if(g.checkForVictory()){
                    Output o = new View();
                    o.doOutput(g.getVictoryPlayerName(), "WINNERFOUND");
                }
                else if(g.checkIfMapFull()){
                    Output o = new View();
                    o.doOutput("", "DRAW");
                }
                else{
                    g.setPlayerTwoTurn();
                    Output o = new View();
                    //if a game is player vs player then we need to tell player two to play.
                    if(GameModel.getInstance().gameType == GameType.PlayerVsPlayer)
                        o.doOutput(g.getMapAsString(), "PLAYERTWOMOVE");
                        //otherwise we need to generate a movement for a computer. And notify user about computers move
                    else{
                        g.makeAComputerMove();
                        o.doOutput("Computer made a following move: "+g.getLastComputerXCoordinate() + " "+g.getLastComputerYCoordinate(), "COMPUTERMOVE");
                    }
                }
            }
            else{
                Output o = new View();
                o.doOutput(g.getMapAsString(), "PLAYERONEMOVEERROR");
            }
        }catch(Exception ex){
            Output o = new View();
            if(GameModel.getInstance().gameName == GameName.TicTacToe){
                g = new TicTacToeController();
                o.doOutput(g.getMapAsString(), "PLAYERONEMOVEERROR");
            }
            else{
                g = new FourInRowController();
                o.doOutput(g.getMapAsString(), "PLAYERONEMOVEERROR");
            }
        }
    }

    /**
     * A method that handles user's input regarding the game type initialization. After handling the input notifies the view about result.
     * @param input
     */
    private void handleInitializeResponse(String input) {
        //Player vs player
        if(input.equals("1"))
        {
            Output o = new View();
            if(GameModel.getInstance().gameName == GameName.TicTacToe){
                g = new TicTacToeController();
                g.setGameType(GameType.PlayerVsPlayer);
            }
            else{
                g = new FourInRowController();
                g.setGameType(GameType.PlayerVsPlayer);
            }
            g.setPlayerOneTurn();
            o.doOutput(g.getMapAsString(), "PLAYERONEMOVE");
        }
        //Player vs computer
        else if(input.equals("2")) {
            Output o = new View();
            if(GameModel.getInstance().gameName == GameName.TicTacToe){
                g = new TicTacToeController();
                g.setGameType(GameType.PlayerVsComputer);
            }
            else{
                g = new FourInRowController();
                g.setGameType(GameType.PlayerVsComputer);
            }
            g.setPlayerOneTurn();
            o.doOutput(g.getMapAsString(), "PLAYERONEMOVE");
        }
        //Wrong input
        else{
            Output o = new View();
            o.doOutput("", "INITIALIZEERROR");
        }
    }

    /**
     * A method that handles user's input from the view regarding the main menu input choice. After handling the input notifies the view about result.
     * @param input
     */
    private void handleWelcomeResponse(String input) {
        //Tic tac toe
        if(input.equals("1"))
            startTicTacToeGame();
            //4 in row
        else if(input.equals("2"))
            startFourInRowGame();
            //Exit
        else if(input.equals("3"))
            System.exit(0);
            //Wrong input
        else{
            Output o = new View();
            o.doOutput("", "WELCOMEERROR");
        }
    }

    /**
     * A method starts Four in a row game but setting the main objects.
     */
    private void startFourInRowGame() {
        g = new FourInRowController();
        g.initializePlayers();
        g.setMap();
        g.setGameName();
        Output o = new View();
        //send user for further initialization. With this we will ask him if he want to play againt player or computer
        o.doOutput("", "INITIALIZEGAME");
    }

    /**
     * A method starts Tic Tac Toe game but setting the main objects.
     */
    private void startTicTacToeGame() {
        g = new TicTacToeController();
        g.initializePlayers();
        g.setMap();
        g.setGameName();
        Output o = new View();
        o.doOutput("", "INITIALIZEGAME");
    }

    /**
     * Implementation of Input interface. A method receives the user input and code as a notification that makes it understand which kind of input user made.
     * @param input
     * @param code
     */
    @Override
    public void useInputData(String input, String code) {
        if(code.equals("WELCOMERESPONSE"))
            handleWelcomeResponse(input);
        else if(code.equals("INITIALIZERESPONSE"))
            handleInitializeResponse(input);
        else if(code.equals("PLAYERONEMOVERESPONSE"))
            handlePlayerOneMoveResponse(input);
        else if(code.equals("PLAYERTWOMOVERESPONSE"))
            handlePlayerTwoMoveResponse(input);
        else if(code.equals("ANOTHERGAMERESPONSE"))
            handleAnotherGameResponse(input);
        else if(code.equals("COMPUTERMOVESHOWN"))
            requestPlayerOneMovement();
    }

    /**
     * A method that sends to view a notification to display input inquiry for player one to make a movement.
     */
    private void requestPlayerOneMovement() {
        if(GameModel.getInstance().gameName == GameName.FourInRow)
            g = new FourInRowController();
        else
            g = new TicTacToeController();
        g.setPlayerOneTurn();
        Output o = new View();
        o.doOutput(g.getMapAsString(), "PLAYERONEMOVE");
    }
}
