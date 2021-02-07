package com.babich.reaction;

import java.util.Calendar;
import java.util.Scanner;

public class Reaction {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println(userName + " please tell me how old you are");
        
        int age = scanner.nextInt();
        // adding scanner.nextLine() below because nextInt doesn't honor \n.  Without nextLine we dont wait for user input.
        scanner.nextLine();
        
        System.out.println(userName + " lets test your reaction time, hit ENTER when you see the word GO");
        int randomInt = getRandomNumber(Calendar.getInstance().get(Calendar.YEAR) - age);
        
        System.out.println("Press Enter to begin.");
        scanner.nextLine();
        Thread.sleep(500);
        System.out.println("Ready...");
        Thread.sleep(randomInt);
        System.out.println("GO!!!");
        long startTime = System.currentTimeMillis();
        scanner.nextLine();
        long endTime = System.currentTimeMillis();
        
        long reactionTime = endTime - startTime;

        if (reactionTime > 500 ) {
            System.out.println("You have a slow reaction speed " + userName + ". It took you more than a half of a second to react!! Have you been drinking?");
        } else {
            System.out.println("You have a great reaction speed " + userName + "!! You only took ." + reactionTime + " seconds to react");
        }

    }
    
    private static int getRandomNumber(int year) {
        return (int) ((Math.random() * year));
    }
}
