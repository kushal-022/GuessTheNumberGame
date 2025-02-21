package com.raghuwanshi.kushal.GuessTheNumber.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private int targetNumber;
    private int attempts;
    private int maxAttempts;
    private boolean gameRunning = false;


    public void startGame(int difficulty) {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;

        switch (difficulty) {
            case 1: maxAttempts = 10; break;
            case 2: maxAttempts = 5; break;
            case 3: maxAttempts = 3; break;
            default: maxAttempts = 5;
        }

        attempts = 0;
        gameRunning = true;

        System.out.println("Great! You selected " + getDifficultyName(difficulty) + " mode.");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " chances to guess it.");
    }



    private String getDifficultyName(int difficulty) {
        return switch (difficulty) {
            case 1 -> "Easy";
            case 2 -> "Medium";
            case 3 -> "Hard";
            default -> "Medium";
        };
    }

    public String guess(int guessedNum) {
        if (!gameRunning) {
            return "Game is not running! Start a new game with 'start-game <difficulty>'.\n";
        }

        if(guessedNum == targetNumber){
            gameRunning = false;
            return "Congratulations :) you have guessed the number right !\n";
        }

        attempts++;

        if(attempts>=maxAttempts){
            gameRunning = false;
            return "Sorry your attempts are over, the correct number was " + targetNumber + "\n";
        }

        if (guessedNum < targetNumber) {
            return "📈 Too low! Try again.";
        } else {
            return "📉 Too high! Try again.";
        }
    }
}
