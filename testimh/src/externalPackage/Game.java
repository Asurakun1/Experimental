package externalPackage;

import java.util.Scanner;

public class Game {
	
	private boolean on = false;
	private Scanner input = new Scanner(System.in);
	private boolean start = false;
	public Game() {
		// TODO Auto-generated constructor stub
		System.out.println("Initialzing system...");
	}
	
	public void start() {
		on = true;
		theLoop();
	}
	
	private void gameStart() {
		Attributes playerStats = new Attributes();
		playerStats.setPts(30);						//Starting stat points
		String playername;
		String input;
		
		System.out.println("Your journey first begins in the character customization\n"
				+ "Tell me. What is your name?");
		input = this.input.next();
		playername = input;
		
		System.out.println("Alright " + playername + " Proceed to stat distriubtion. \n"
				+ "to bring up the stats menu type 'stats");
		
		while(start == true) {
			if(input.equals("exit")) {
				start = false;	
				break;
			}
			
			if(input.equals("stats") || input.equals("Stats")) {
				playerStats.addPtsToStat();
			}
			
			input = this.input.next();
		}
		return;
	}
	
	private void theLoop() {
		System.out.println("Done.");
		String input;
		while(on == true) {
			
			System.out.println("\nWelcome to the experimental terminal.\n"
					+ "This is in the testing phase. Type 'Start' to begin. Type 'exit' to terminate the application");
			
			input = this.input.next();
			
			//simple terminate
			if(input.equals("exit")) {
				on = false;
				System.out.println("\nTerminating the program...");
				Runtime.getRuntime().exit(1);
			}
			
			if(input.equals("start") || input.equals("Start")){
				start = true;
				
				//real game loop begins
				gameStart();
			}
		}
		
		this.input.close();
	}
	
}
