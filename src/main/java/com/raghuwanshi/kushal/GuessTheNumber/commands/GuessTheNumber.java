package com.raghuwanshi.kushal.GuessTheNumber.commands;

import com.raghuwanshi.kushal.GuessTheNumber.service.GameService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class GuessTheNumber {

    private final GameService gameService;

    public GuessTheNumber(GameService gameService) {
        this.gameService = gameService;
    }

    @ShellMethod(key = "start-game", value = "Starts a new game. Usage: start-game <difficulty>")
    public String chooseDifficulty(int difficulty) {
       gameService.startGame(difficulty);
       return "Game started! Now enter your guesses using 'guess <number>'";
    }

    @ShellMethod(key = "guess", value = "Make a guess. Usage: guess <number>")
    public String guess(int guessedNum) {
        return gameService.guess(guessedNum);
    }
}
