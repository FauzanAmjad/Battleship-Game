import java.util.Scanner;

public class BattleshipDriver {

	public static void main(String[] args) {
		
		//How many wins the player has
		int playerWins = 0;
		
		//How many wins the computer has
		int computerWins = 0;
		
		//Tracks the round number
		int roundNumber = 1;
		
		//While loop breaks when the player is done playing the game - let's the player go first
		while(true) {
		
			//Prints round number
			System.out.println("Round Number " + roundNumber);
			
			//Create a new Battleship game
			Battleship newGame = new Battleship();
			
			//Allows the computer and player to alter who goes first
			if(roundNumber%2 == 1) {
				
				//If the game return true, then the player won
				if(game(newGame)) {
					
					//Prints the player has won
					System.out.println("Congratulations! You won this game!");
					
					//Increments wins of the player by one
					playerWins++;
					
				}
				
				//If false, then the computer has won
				else {
					
					//Prints the computer has won
					System.out.println("Sorry! You lost this game!");
					
					//Increments wins of the computer by one
					computerWins++;
					
				}
			
			}
			
			//Let's the computer go first
			else {
				
				//If the game return true, then the player won
				if(game2(newGame)) {
					
					//Prints the player has won
					System.out.println("Congratulations! You won this game!");
					
					//Increments wins of the player by one
					playerWins++;
					
				}
				
				//If false, then the computer has won
				else {
					
					//Prints the computer has won
					System.out.println("Sorry! You lost this game!");
					
					//Increments wins of the computer by one
					computerWins++;
					
				}
			
			}
			
			//Prints wins and losses of the player
			System.out.println("Wins: " + playerWins + " Losses: " + computerWins);
			
			//Create a scanner 
			Scanner stc = new Scanner(System.in);
			
			//Stores whether they want to continue or not
			int input;
			
			//While loop is create to prevent invalid input
			while(true) {
				
				//Try to get correct input 
				try {
					
					//Ask for user input
					System.out.println("Would you like to play another game? Enter 1 for YES or Enter 2 for NO: ");
					
					//Get user input
					input = stc.nextInt();
					
					//Check if input is valid
					if(input == 1 || input == 2) {
						
						//Breaks while loop if input is valid
						break;
					
					}
					
					//Tells them to enter a valid input
					System.out.println("Enter valid input.");
					
				}
				
				//Catches incorrect input 
				catch(Exception e) {
					
					//Prints that they have invalid input
					System.out.println("Invalid input!");
					
				}
					
			}
			
			//Check if player wants to end the game
			if(input == 2) {
				
				//Breaks if player wants to end the game
				break;
				
			}
			
			//Increments the round number 
			roundNumber++;
		
		}
		
		
		//Thank you message
		System.out.println("Thank you for playing!");
		
		
	}
	
	public static boolean game(Battleship game) {
		
		//Value is whoever wins the game
		boolean winLoss = false;
		
		//Keeps iterating through moves until someone wins
		while(true) {
			
			//Prints whats going to be printing
			System.out.println("Your notes of your opponent's territory: ");
			
			//Prints player previous action
			game.printPlayerNotes();
			
			//Separation
			System.out.println("----------");
			
			//Let's player make a move
			game.playerMove();
			
			//Check to see if player has won
			if(game.checkPlayerWin()) {
				
				//winLoss is true when player wins
				winLoss = true;
				
				//breaks if win
				break;
				
			}
			
			//Let's the computer make a move
			game.computerMove();
			
			//Checks to see if computer has won
			if(game.checkComputerWin()) {
				
				//winLoss if false if computer won
				winLoss = false;
				
				//breaks after wins
				break;
				
			}
			
			//Tell user about their territory
			System.out.println("This is your territory right now: ");
			
			//Prints current territory after computer's move
			game.printPlayerArray();
			
			//Separation
			System.out.println("----------");
			
		}
		
		//Returns who won
		return winLoss;
		
	}
	public static boolean game2(Battleship game) {
		
		//Value is whoever wins the game
		boolean winLoss = false;
		
		//Keeps iterating through moves until someone wins
		while(true) {
			
			//Let's the computer make a move
			game.computerMove();
			
			//Checks to see if computer has won
			if(game.checkComputerWin()) {
				
				//winLoss if false if computer won
				winLoss = false;
				
				//breaks after wins
				break;
				
			}
			
			//Tell user about their territory
			System.out.println("This is your territory right now: ");
			
			//Prints current territory after computer's move
			game.printPlayerArray();
			
			//Separation
			System.out.println("----------");
			
			//Prints whats going to be printing
			System.out.println("Your notes of your opponent's territory: ");
			
			//Prints player previous action
			game.printPlayerNotes();
			
			//Separation
			System.out.println("----------");
			
			//Let's player make a move
			game.playerMove();
			
			//Check to see if player has won
			if(game.checkPlayerWin()) {
				
				//winLoss is true when player wins
				winLoss = true;
				
				//breaks if win
				break;
				
			}
			
		}
		
		//Returns who won
		return winLoss;
		
	}
		
}
