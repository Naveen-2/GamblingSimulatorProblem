package com;

import java.util.Scanner;

public class Gambler {
	
	
	Gambler(){
		/**
		 * Constructor to read user stake amount and default bet amount*/
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter number of days you want to play: ");
		numberOfDays = input.nextInt();
		System.out.print("Please enter an amount to start with: ");
		stakeAmount = input.nextInt();
		System.out.print("Please enter an amount to bet every match: ");
		startingBetAmount = input.nextInt();
		input.close();
	}
	
	int stakeAmount;
	int numberOfDays;
	int startingBetAmount;
	int initialStakeAmount;
	int maximumWinningAmount;
	int maximumLosingAmount;
	
	public void initiateBetting() {
		initialStakeAmount = stakeAmount;
		maximumWinningAmount = initialStakeAmount + (initialStakeAmount/2);
		maximumLosingAmount = initialStakeAmount - (initialStakeAmount/2);
	}
	
	void bet() {
		double isBetWon = Math.floor((Math.random() * 10) % 2);
		//System.out.println(isBetWon);
		
		/**
		 * if player won bet amount will be added to stake amount 
		 * else it'll be deducted */
		if(isBetWon == 1) {
			//System.out.println("Player Won the round.");
			stakeAmount += startingBetAmount;

			//System.out.println(stakeAmount);
			
		} else if (isBetWon == 0) {
			//System.out.println("Player Lost the round.");
			stakeAmount -= startingBetAmount;
			//System.out.println(stakeAmount);
			
		}
	}
	
	boolean gamblerLeavingStage() {
		
		while(stakeAmount < maximumWinningAmount || stakeAmount > maximumLosingAmount) {
			
			bet();
			
			/** if player reaches maximum winning amount
			 * return true
			 */
			
			if(stakeAmount == maximumWinningAmount)
				return false;
			
			/**player reaches maximum losing amount
			 * return false
			 */
			else if(stakeAmount == maximumLosingAmount)
				return true;
		}
		
		return true;
	}
}