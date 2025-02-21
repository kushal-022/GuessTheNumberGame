package com.raghuwanshi.kushal.GuessTheNumber.commands;

import org.jline.utils.AttributedString;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShellStartupMessage {

    @EventListener(ContextRefreshedEvent.class)
    public void onStartup() {
        System.out.println("\n****************************************");
        System.out.println("*  🎉 Welcome to Guess The Number! 🎉  *");
        System.out.println("*  Type 'start-game <difficulty>'      *");
        System.out.println("*  to begin. Difficulty Levels:        *");
        System.out.println("*  1. Easy (10 chances)                *");
        System.out.println("*  2. Medium (5 chances)               *");
        System.out.println("*  3. Hard (3 chances)                 *");
        System.out.println("****************************************\n");
    }
}
