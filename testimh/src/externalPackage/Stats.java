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
	private int[] lvl = new int[50];
	private int temp1, temp2, temp3, temp4, temp5;
	private int currentlevel = 1;
	private int statpts;
	private Scanner input = new Scanner(System.in);
	
	private int Exp = 0, reachExp = 1000;
	
	//RNG object. Praise thee RnG Jesus!
	Random rand = new Random();
	
	public int setPts(int numberOfPoints) {
		statpts = numberOfPoints;
		return statpts;
	}
	
	public void addPtsToStat() {
		boolean run = true;
		String input;
		System.out.println("Now testing the system. if posts then does as expected.");
		
		while(run) {
			
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
			reachExp = (int) (reachExp * 4.987654321);
			
//			System.out.println(lvl[i]); dont mind this. just testing out exp requirement gen
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
	
	public void getStats(int temp, int temp2, int temp3, int temp4, int temp5) {
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
