package com;

import java.util.Scanner;

public class Gambler {

	int stakeAmount;
	int numberOfDays;
	int startingBetAmount;
	int initialStakeAmount;
	int maximumWinningAmount;
	int maximumLosingAmount;
	int currentMonthWinning;
	int currentMonthLost;
	
	Gambler(){
		/**
		 * Constructor to read user stake amount and default bet amount*/
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of days you want to play for a month: ");
		numberOfDays = input.nextInt();
		System.out.print("Please enter an amount to start with every day: ");
		initialStakeAmount = input.nextInt();
		System.out.print("Please enter an amount to bet every match: ");
		startingBetAmount = input.nextInt();
		input.close();
	}
	
	
	public void initiateBetting() {
		stakeAmount = initialStakeAmount;
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
	
	void calculateCurrentMonthStake(int amount, int dayResult){
		if(dayResult == 0)
			currentMonthLost = currentMonthLost + amount;
		else if (dayResult == 1)
			currentMonthWinning = currentMonthWinning + amount;
	}
	
	/**
	 * player will play till the maximum days he enters
	 */
	void startPlayingThisMonth() {
		currentMonthWinning = 0;
		currentMonthLost = 0;
		
		for(int i = 1; i <= numberOfDays; i++) {
			
			initiateBetting();
	
			boolean isGamblerLeft = gamblerLeavingStage();
	
			if(isGamblerLeft) {
				System.out.println("Day "+i+": Lost today. Current Stake: Rs. " + stakeAmount);
				calculateCurrentMonthStake(stakeAmount, 0);
			} else {
				System.out.println("Day "+i+": Won today. Current Stake Rs. " + stakeAmount);
				calculateCurrentMonthStake(stakeAmount - initialStakeAmount, 1);
			}
			
		}

		System.out.println("Total amount won this month is Rs. " + (currentMonthWinning));
		System.out.println("Total amount lost this month is Rs. " + (currentMonthLost));
		
		if(currentMonthWinning > currentMonthLost) {
			System.out.println("As we played well this month, let's continue for another month.");
			startPlayingThisMonth();
		} else if(currentMonthWinning == currentMonthLost){
			System.out.println("Nothing bad, Nothing good. We can still play another month.");
			startPlayingThisMonth();
		} else {
			System.out.println("It's been a terrible month and faced a loss, let's pause betting for next month.");
		}
	}
}