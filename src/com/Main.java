package com;

public class Main {

	public static void main(String[] args) {
		/*new gambler object is created */
			
		Gambler gambler = new Gambler();
		/**
		 * player will play till the maximum days he enters
		 */
		for(int i = 1; i <= gambler.numberOfDays; i++) {
			
			gambler.initiateBetting();
	
			boolean isGamblerLeft = gambler.gamblerLeavingStage();
	
			if(isGamblerLeft) {
				System.out.println("Day "+i+": Gambler Lost today :(");
			} else {
				System.out.println("Day "+i+": Gambler Won today :)");
			}
			
		}
	}

}
