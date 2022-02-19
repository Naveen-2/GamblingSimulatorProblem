package com;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an amount to start with: ");
		int initialBetAmount = input.nextInt();
		System.out.println("Please enter an amount to bet every match: ");
		int startingBetAmount = input.nextInt();
		Gambler gambler = new Gambler(initialBetAmount, startingBetAmount);
		
	}

}
