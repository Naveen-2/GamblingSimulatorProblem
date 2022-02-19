package com;

import java.util.Scanner;

public class Gambler {
	int stakeAmount;
	int startingBetAmount;
	
	Gambler(){
		/**
		 * Constructor to read user stake amount and default bet amount*/
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter an amount to start with: ");
		stakeAmount = input.nextInt();
		System.out.print("Please enter an amount to bet every match: ");
		startingBetAmount = input.nextInt();
		input.close();
	}
	
	void bet() {
		double isBetWon = Math.floor((Math.random() * 10) % 2);
		System.out.println(isBetWon);
		if(isBetWon == 1) {
			System.out.println("Player Won the round.");
			stakeAmount += 1;
			
		} else if (isBetWon == 0) {
			System.out.println("Player Lost the round.");
			stakeAmount -= 1;
		}
	}
}