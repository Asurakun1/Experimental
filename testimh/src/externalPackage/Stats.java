package externalPackage;

import java.util.Random;
import java.util.Scanner;

/*
 * Level up Stat database current form is based off of RnG(Praise thee lord RnG jesus!). 
 * 
 * Future implementations is user based addition upon stat distribution
 * 
 * version 0.0.2
 * 
 * @Author Asurakun1
 */

public class Stats {
	
	
	//Dear god my long list of variables
	private int Str;
	private int Int;
	private int Dex;
	private int Will;
	private int Luck;
	private long[] lvl = new long[50];
	private int temp1, temp2, temp3, temp4, temp5;
	private int currentlevel = 1;
	private int statpts;
	private Scanner input = new Scanner(System.in);
	
	private long Exp = 0, reachExp = 1000;
	
	//RNG object. Praise thee RnG Jesus!
	Random rand = new Random();
	
	public int setPts(int numberOfPoints) {
		statpts = numberOfPoints;
		return statpts;
	}
	
	public void addPtsToStat() {
		boolean run = true;
		String input;
		int inputV;
		System.out.println("Now testing the system. if posts then does as expected.");
		
		while(run) {
			/*
			 * This is the stat distribution system.
			 * Goal is to have user defined stats instead of presets generated by RnG(Praise thee lord Rng Jesus!)
			 * Method to run for as long as many levels until level cap.
			 * Reaching level cap will have about 1-3 extra points. 
			 * REMEMBER this is just an experiment not a complete project.
			 */
			System.out.println("Character Stats: \n");
			getStats();
			
			while(statpts > 0) {
				System.out.println("You have a total of " + statpts + " ability points available for stat distributition.");
				System.out.println("Select the stat and the amount you would like to distribute to. Type 'exit' to return back");
				
				input = this.input.next();

				if(input.equals("exit")) {
					break;
				}
				
				
				//Strength allocator
				if(input.equals("Str") || input.equals("str")||input.equals("STR")) {
					while(true) {
						System.out.println("Strength has been selected. How many points would you like to distribute?");
						
						inputV = this.input.nextInt();
						
						if(inputV > statpts) {
							System.out.println("Invalid amount. Exeeded the total amount of points available.\n");
						}else if(inputV < 0) {
							System.out.println("Invalid amount. Type cannot be a negative value.\n");
						}else if(inputV == 0){
							System.out.println("Invalid amount. You cannot add nothing with nothing.\n" );
						}else {
							this.Str = inputV;
							statpts = statpts - inputV;		
							System.out.println("Your strength increased by " + inputV + ".\n");
							getStats();
							break;
						}
						
					}
					
				}
				//Intelligence allocator
				if(input.equals("Int") || input.equals("int")||input.equals("INT")) {
					while(true) {
						System.out.println("Intelligence has been selected. How many points would you like to distribute?");
						
						inputV = this.input.nextInt();
						
						if(inputV > statpts) {
							System.out.println("Invalid amount. Exeeded the total amount of points available.\n");
						}else if(inputV < 0) {
							System.out.println("Invalid amount. Type cannot be a negative value.\n");
						}else if(inputV == 0){
							System.out.println("Invalid amount. You cannot add nothing with nothing.\n" );
						}else{
							this.Int = inputV;
							statpts = statpts - inputV;
							System.out.println("Your Intelligence increased by " + inputV + ".\n");
							getStats();
							break;
						}
						
					}
					
				}
				//Dexterity allocator
				if(input.equals("Dex") || input.equals("dex")||input.equals("DEX")) {
					while(true) {
						System.out.println("Dexterity has been selected. How many points would you like to distribute?");
						
						inputV = this.input.nextInt();
						
						if(inputV > statpts) {
							System.out.println("Invalid amount. Exeeded the total amount of points available.\n");
						}else if(inputV < 0) {
							System.out.println("Invalid amount. Type cannot be a negative value.\n");
						}else if(inputV == 0){
							System.out.println("Invalid amount. You cannot add nothing with nothing.\n" );
						}else{
							this.Dex = inputV;
							statpts = statpts - inputV;
							System.out.println("Your Dexterity increased by " + inputV + ".\n");
							getStats();
							break;
						}	
					}	
				}
				//Will allocator
				if(input.equals("will") || input.equals("Will") || input.equals("Wll") || input.equals("wll")||input.equals("WLL")) {
					while(true) {
						System.out.println("Will has been selected. How many points would you like to distribute?");
						
						inputV = this.input.nextInt();
						
						if(inputV > statpts) {
							System.out.println("Invalid amount. Exeeded the total amount of points available.\n");
						}else if(inputV < 0) {
							System.out.println("Invalid amount. Type cannot be a negative value.\n");
						}else if(inputV == 0){
							System.out.println("Invalid amount. You cannot add nothing with nothing.\n" );
						}else{
							this.Will = inputV;
							statpts = statpts - inputV;
							System.out.println("Your Will increased by " + inputV + ".\n");
							getStats();
							break;
						}	
					}	
				}
				//Luck allocator
				if(input.equals("Luck") || input.equals("luck") || input.equals("lck")||input.equals("LCK")||input.equals("Lck")) {
					while(true) {
						System.out.println("Luck has been selected. How many points would you like to distribute?");
						
						inputV = this.input.nextInt();
						
						if(inputV > statpts) {
							System.out.println("Invalid amount. Exeeded the total amount of points available.\n");
						}else if(inputV < 0) {
							System.out.println("Invalid amount. Type cannot be a negative value.\n");
						}else if(inputV == 0){
							System.out.println("Invalid amount. You cannot add nothing with nothing.\n" );
						}else{
							this.Luck = inputV;
							statpts = statpts - inputV;
							System.out.println("Your Luck increased by " + inputV + ".\n");
							getStats();
							break;
						}	
					}	
				}
				
//				getStats();
				
			} //end of loop
			
			System.out.println("Type 'exit' to exit the stat menu");
			input = this.input.next();
			
			if(input.equals("exit") || input.equals("Exit")) {
				run = false;
				return;
			}
			
		}
		
	}
	
	public Stats() {
		//stats are preset at random integers
		this.Str = 0;
		this.Int = 0;
		this.Dex = 0;
		this.Will = 0;
		this.Luck = 0;
		
		//base exp for starting character	
		setExpRequirements();
		
	}
	
	//User-defined stats. will make limit when i feel like it
	public Stats(int str, int Int, int Dex, int Will, int Luck) {
			this.Str = str;
			this.Int = Int;
			this.Dex = Dex;
			this.Will = Will;
			this.Luck = Luck;
		setExpRequirements();
	}
	
	private void setExpRequirements() {
		//Initiliazing experience requirement current max level 50
		for(int i = 1; i < lvl.length; i++) {
			lvl[i] = reachExp;
			reachExp = (long) (reachExp * 1.543210);
			
//			System.out.println(lvl[i]); dont mind this. just testing out exp requirement gen
		}
	}
	
	public void getExpRequirements() {
		for(int i = 1; i < lvl.length; i++) {
			System.out.println(lvl[i]);
		}
	}
	
	public void getStats() {
		
		//this just posts your stats. nothing much here.
		System.out.println("Level: " + currentlevel);
		System.out.println("---------------");
		System.out.println("STR: " + Str);
		System.out.println("INT: " + Int);
		System.out.println("DEX: " + Dex);
		System.out.println("WLL: " + Will);
		System.out.println("LCK: " + Luck);
		System.out.println("");
		
	}
	
	// reposts for every new level up
	
	private void getStats(int temp, int temp2, int temp3, int temp4, int temp5) {
		System.out.println("Level: " + (currentlevel + 1) );
		System.out.println("---------------");
		System.out.println("STR: " + Str + " + " + temp1);
		System.out.println("INT: " + Int + " + " + temp2);
		System.out.println("DEX: " + Dex + " + " + temp3);
		System.out.println("WLL: " + Will + " + "+ temp4);
		System.out.println("LCK: " + Luck + " + "+ temp5);
		System.out.println("");
	}
	
	//THE actual level up and RnG stat distribution
	
	private void lvlUp() {
		
		//making sure level up does not give +0. Total buzz kill
		
		temp1 = rand.nextInt(3)+1;
		temp2 = rand.nextInt(3)+1;
		temp3 = rand.nextInt(3)+1;
		temp4 = rand.nextInt(3)+1;
		temp5 = rand.nextInt(3)+1;
		
		getStats(temp1, temp2, temp3, temp4, temp5);
		
		this.Str = Str + temp1;
		this.Int = Int + temp2;
		this.Dex = Dex + temp3;
		this.Will = Will + temp4;
		this.Luck = Luck + temp5;
		
		//one up!
		currentlevel = currentlevel + 1;
		
	}
	
	//The stuff that really works here.
	
	public void addExp(int add) {
		float calc = 0;
		Exp = Exp + add;
		System.out.println(add + " Exp gained!");
		System.out.println("=======================");

		
		//lvl array holds current exp path to next level
		if(Exp > lvl[currentlevel]) {
			System.out.println("Level up!");
			lvlUp();
			
			calc = ((float)Exp/lvl[currentlevel])*100;
			
			System.out.println("Progress: " + Exp + " / " + lvl[currentlevel] + " = " + (int)calc + "%" + " Complete! ");
			System.out.println("");
			if(add > lvl[currentlevel]) {
				System.out.println((add - lvl[currentlevel]) + " Exp gained!");
				System.out.println("=======================");
				System.out.println("");
			}
			
			while(Exp > lvl[currentlevel]) {
				
				System.out.println("Level up!");
				lvlUp();
				
				calc = ((float)Exp/lvl[currentlevel])*100;
				
				System.out.println("Progress: " + Exp + " / " + lvl[currentlevel] + " = " + (int)calc + "%" + " Complete! ");
				System.out.println("");
				if(add > lvl[currentlevel]) {
					System.out.println((add - lvl[currentlevel]) + " Exp gained!");
					System.out.println("=======================");
					System.out.println("");

				}
			}
			
		} 
		else{
			calc = ((float)Exp/lvl[currentlevel])*100;
			System.out.println("Progress: " + Exp + " / " + lvl[currentlevel] + " = " + (int)calc + "%" + " Complete! ");
		}
		
	}
}
