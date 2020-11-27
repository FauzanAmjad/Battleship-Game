import java.util.*;

public class Battleship {

	//Computer's territory
	private boolean[][] computerBoard = new boolean[5][5];
	
	//Player's territory
	private boolean[][] playerBoard = new boolean[5][5];
	
	//Notes of what the player has hit
	private char[][] playerNotes = new char[5][5];
	
	//The list of what the computer is going to do
	private ArrayList<Integer[]> computerMoves = new ArrayList<Integer[]>();
	
	//The maximum number of ships allowed 
	final private int MAXIMUM_SHIPS = 5;
	
	//Constructor
	public Battleship() {
		
		//Makes the board for the computer
		makeComputerBoard();
		
		//Make the board for the player
		makePlayerBoard();
		
		//Initialized the notes of the player 
		initializePlayerNotes();
		
		//Pre determines what moves the computer is going to do
		makeComputerMoves();
	
	}
	
	//Makes the board for the computer
	private void makeComputerBoard() {
		
		//Keeps the values
		ArrayList<Boolean> values = new ArrayList<Boolean>();
		
		//Tracks number of ships
		int ships = 0;
		
		//Goes through rows
		for(int i = 0; i < computerBoard.length; i++) {
			
			//Goes through columns
			for(int j = 0; j < computerBoard[i].length; j++) {
				
				//Adds ships if maximum ships hasn't been reached
				if(ships < MAXIMUM_SHIPS) {
					
					//Adds a ship
					values.add(true);
					
					//Tracks ships
					ships++;
				
					//Continues to prevent further values from being added
					continue;
					
				}
				
				//Adds false if max ships has been reached
				values.add(false);
				
			}
			
		}
		
		//Shuffle
		Collections.shuffle(values);
		
		//Shuffle
		Collections.shuffle(values);
		
		//Shuffle
		Collections.shuffle(values);
		
		//Goes through rows
		for(int i = 0; i < computerBoard.length; i++) {
		
			//Goes through columns
			for(int j = 0; j < computerBoard[i].length; j++) {
			
				//Puts ship or does nothing at current position 
				computerBoard[i][j] = values.get(0);
				
				//Removes that value from the array
				values.remove(0);
			
			}
		
		}		
	
	}
	
	//Allows the player to create a board
	private void makePlayerBoard() {
		
		//Tell player what do do
		System.out.println("We're going to make your board. You have 5 ships.");
		
		//Creates scanner
		Scanner stc = new Scanner(System.in);
		
		//Tracks number of ships place
		int trueValues = 0;
		
		//Tracks number of positions on board done
		int doneValues = 0;
		
		//Goes through rows
		for(int i = 0; i < playerBoard.length; i++) {
		
			//Goes through columns
			for(int j = 0; j < playerBoard[i].length; j++) {
				
				//Fills in the remaining values (Ex. 
				if((MAXIMUM_SHIPS - trueValues) == (25 - doneValues)) {
			
					//Places ships
					playerBoard[i][j] = true;
				
					//Continues the for loop
					continue;
			
				}
				
				//Checks to see if ship threshold has been reached
				if(trueValues == MAXIMUM_SHIPS) {
			
					//Breaks while loop if threshold has been reached
					break;
			
				}
				
				//Tell user what they can input
				System.out.println("Enter 1 to place ship or 2 to skip for Row: " + (i + 1) + " Column: " + (j + 1));
				
				//Stores entered value
				int enteredValue = 0;
				
				//Determines whether input is good
				boolean check = true;
				
				//Checks to see if user can even input the value
				try {
				
					//Get user input
					enteredValue = stc.nextInt();
					
				}
			
				//Catches any invalid input exception
				catch(Exception E) {
			
					//Alerts user
					System.out.println("Error! Try again!");
			
					//Decrements j to re do input
					j--;
		
					//Input is not good
					check = false;
				
				}
				
				//If input isn't good
				if(!check) {
					
					//Restarts loops if input isn't good
					continue;
					
				}
				
				//Checks to see if input is invalid after we check if it's an actual number
				if(enteredValue != 1 && enteredValue != 2) {
				
					//Alerts user
					System.out.println("Error! Try again!");
				
					//Decrements j to re do input
					j--;
				
					//Input is not good
					continue;
				
				}
				
				//If user has entered the value 1
				if(enteredValue == 1) {
				
					//Place a ship
					playerBoard[i][j] = true;
					
					//Increment # of ships put
					trueValues++;
					
					//Increment positions visited
					doneValues++;
				
				}
			
				//If user has entered the value 2
				else if(enteredValue == 2) {
				
					//Doesn't place a ship - EMPTY TERRITORY
					playerBoard[i][j] = false;
				
					//Increment positions visited
					doneValues++;
				
				}
				
				//Prints the player's board
				printPlayerArray();
				
			}
			
			
		
		}
		
		
		
	}
	
	//Prints the computer's array - DEBUUGGING PURPOSES ONLY
	private void printComputerArray() {
		
		for(int i = 0; i < computerBoard.length; i++) {
			
			for(int j = 0; j < computerBoard[i].length; j++) {
			
				boolean temp = computerBoard[i][j];
			
				try {
			
					if(temp) {
					
						System.out.print('X' + " ");
				
					}
				
					else {
					
						System.out.print('O' + " ");
				
					}
			
				}
				
				catch(Exception E) {
				
					System.out.print('-' + " ");
			
				}
				
			}
			
			System.out.println();
	
		}
	
	}
	
	//Prints the board for the player
	public void printPlayerArray() {
		
		for(int i = 0; i < playerBoard.length; i++) {
			
			for(int j = 0; j < playerBoard[i].length; j++) {
				
				try {
					
					if(playerBoard[i][j]) {
						
						System.out.print('X' + " ");
					
					}
					
					else {
						
						System.out.print('O' + " ");
					
					}
				
				}
				
				catch(Exception E) {
				
					System.out.print('-' + " ");
				
				}
				
			}
			
			System.out.println();
		
		}
		
	}
	
	//Pre Determines the moves for the computer to do on the player
	private void makeComputerMoves() {
		
		//Positions that the computer can hit being stored into an ArrayList
		for(int i = 0; i < playerBoard.length; i++) {
			
			for(int j = 0; j < playerBoard[i].length; j++) {
				
				computerMoves.add(new Integer[] { i , j });
				
			}
		}
		
		//Shuffle moves
		Collections.shuffle(computerMoves);
		
		//Shuffle moves
		Collections.shuffle(computerMoves);
		
		//Shuffle moves
		Collections.shuffle(computerMoves);
		
	}
	
	//Initializes player notes as a 2D array filled with dashes
	private void initializePlayerNotes() {
		
		for(int i = 0; i < playerNotes.length; i++) {
			
			for(int j = 0; j< playerNotes[i].length; j++) {
				
				playerNotes[i][j] = '-';
				
			}
			
		}
		
	}
	
	//Invoked so that the computer can make a move on the player
	public void computerMove() {
		
		//If there is a ship there
		if(playerBoard[computerMoves.get(0)[0]][computerMoves.get(0)[1]]) {
			
			//Remove the ship
			playerBoard[computerMoves.get(0)[0]][computerMoves.get(0)[1]] = false;
			
			//Say a ship has been hit
			System.out.println("Your opponent has hit a ship");
		
		}
		
		//If no ship is there
		else {
		
			//Say no ship was hit
			System.out.println("Your opponent has missed!");
		
		}
		
		//Remove move to prevent computer from duplicate moves
		computerMoves.remove(0);
		
	}
	
	//Allows the player to make a move on the computer
	public void playerMove() {
		
		//Create a scanner
		Scanner stc = new Scanner(System.in);
		
		//Value for inputed row
		int row;
		
		//Value for inputed column
		int column;
		
		//Breaks when valid values have been entered
		while(true) {
			
			//Asks for row
			System.out.println("Enter row you want to hit: ");
			
			//Stores row
			row = stc.nextInt();
			
			//Checks if its a valid row
			if(row > computerBoard.length || row < 1) {
				
				//Tells that values aren't valid
				System.out.println("That row doesn't exist!");
				
				//Restarts while loop
				continue;
				
			}
			
			//Asks for column
			System.out.println("Enter column you want to hit: ");
			
			//Stores column
			column = stc.nextInt();
			
			//Checks if its a valid column
			if(column > computerBoard[row - 1].length || column < 1) {
				
				//Tells that value isn't valid
				System.out.println("That column doesn't exist!");
				
				//Restarts while loop
				continue;
				
			}
			
			//Checks to see if move was already done
			if(playerNotes[row - 1][column - 1] == 'X' || playerNotes[row - 1][column - 1] == 'O') {
				
				//Tells user of duplication
				System.out.println("You've already checked there!");
				
				//Restarts while loop
				continue;
				
			}
			
			//Breaks inputs are valid
			break;
			
		}
		
		//Decrements row
		row--;
		
		//Decrements column
		column--;
		
		//If there's a ship
		if(computerBoard[row][column]) {
			
			//Removes ship
			computerBoard[row][column] = false;
			
			//Updates notes
			playerNotes[row][column] = 'X';
			
			//Tells user they hit a ship
			System.out.println("You hit a ship!");
		
		}
		
		//If there's no ship
		else {
			
			//Updates noes 
			playerNotes[row][column] = 'O'; 
			
			//Tells user they missed
			System.out.println("You missed!");
		
		}
		
	
	}
	
	
	//Checks to see if player won
	public boolean checkPlayerWin() {
		
		for(int i = 0; i < computerBoard.length; i++) {
			
			for(int j = 0; j < computerBoard[i].length; j++) {
				
				if(computerBoard[i][j]) {
					
					//Returns false if they haven't won yet
					return false;
					
				}
				
			}
			
		}
		
		//Returns true if player has won
		return true;
		
	}
	
	//Checks to see if computer has won
	public boolean checkComputerWin() {
		
		for(int i = 0; i < playerBoard.length; i++) {
			
			for(int j = 0; j < playerBoard[i].length; j++) {
				
				if(playerBoard[i][j]) {
					
					//Returns false if computer hasn't won yet
					return false;
					
				}
				
			}
			
		}
		
		//Returns true if computer has won
		return true;
		
	}
	
	//Prints the player notes
	public void printPlayerNotes() {
		
		for(int i = 0; i < playerNotes.length; i++) {
			
			for(int j = 0; j < playerNotes[i].length; j++) {
				
				System.out.print(playerNotes[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
}
