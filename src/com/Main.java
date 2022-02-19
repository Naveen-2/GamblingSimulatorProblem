package com;

public class Main {

	public static void main(String[] args) {
		/*new gambler object is created */
		Gambler gambler = new Gambler();
		
		gambler.initiateBetting();

		boolean isGamblerLeft = gambler.gamblerLeavingStage();

		if(isGamblerLeft) {
			System.out.println("Gambler Lost the maximum losing amount for the day :(");
		} else {
			System.out.println("Gambler Won his maximum winning amount for the day :)");
		}

	}

}
