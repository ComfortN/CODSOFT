package org.example.numberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {


    /**
     *
     * @param min The minimum number that is generated.
     * @param max The maximum number that is generated.
     * @return  The random number that is generated.
     */
    public static int generateNum(int min, int max){

        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     *
     * @param randomNum The generated random number.
     * @param scanner The scanner for the user input.
     */
    public static void theGame( int randomNum, Scanner scanner){
        int numOfTries = 5;
        boolean correctGuess = false;

        System.out.println("The Number Game!");
        System.out.println("Guess a number between 1 and 100 in 5 tries.");

        while (!correctGuess) {
            System.out.println("Enter your guess: ");
            int userGuess = scanner.nextInt();


            if (userGuess == randomNum) {
                correctGuess = true;
                System.out.println("Correct guess (" + randomNum + ") in " + (5 - numOfTries + 1) + " tries.");
            } else if (userGuess < randomNum) {
                System.out.println("The number is higher.");
                numOfTries--;
            } else {
                System.out.println("The number is lower.");
                numOfTries--;
            }

            if (numOfTries == 0) {
                System.out.println("No more tries");
                System.out.println("The number was: " + randomNum);
                break;
            }
        }

//        return numOfTries;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int min = 1;
            int max = 100;
            int randomNum = generateNum(min, max);
            theGame(randomNum, scanner);

            System.out.println("Do you want to play again? (y/n): ");

            String play = scanner.next().toLowerCase();
            if (!play.equals("y")) {
                playAgain = false;
                System.out.println("Thank you for playing");
            }
        }

        scanner.close();
    }
}