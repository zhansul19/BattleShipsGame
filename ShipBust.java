package BattleShipsGame;

import java.util.ArrayList;

public class ShipBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        Ship one = new Ship();
        one.setName("poniez");
        Ship two = new Ship();
        two.setName("hacqi");

        Ship three = new Ship();
        three.setName("cabista");
        ships.add(one);
        ships.add(two);
        ships.add(three);

        System.out.println("Your goal is to sink three ships.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (Ship ship : ships) {
            ArrayList<String> newLocation = helper.placeShip(3);
            ship.setLocationCells(newLocation);
        }
    }

    void startPlaying() {
        while (!ships.isEmpty()) {
            String userInput = helper.getUserInput("take a guess");
            checkUserGuess(userInput);
        }
        finishGame();
    }

    void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for (Ship ship : ships) {
            result = ship.checkYourself(userGuess);
            if (result == "hit") {
                break;
            }
            if (result == "kill") {
                ships.remove(ship);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All ships are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        ShipBust game = new ShipBust();
        game.setUpGame();
        game.startPlaying();
    }
}
