package externalPackage;

import java.util.Random;

/*
 * Level up Stat database current form is based off of RnG(Praise thee lord RnG jesus!). 
 * 
 * Future implementations is user based addition upon stat distribution
 * 
 * version 0.0.1
 * 
 * This is an old version and will not be used. Therefore it will not be updated.
 * 
 * @Author Asurakun1
 */

public class Stats2 {
	
	
	//Dear god my long list of variables
	private int Str;
	private int Int;
	private int Dex;
	private int Will;
	private int Luck;
//	private int[] lvl = new int[20];
	private int lvl;
	private int temp1, temp2, temp3, temp4, temp5;
	private int currentlevel = 1;
	
	private int Exp, reachExp = 1000;
	
	//RNG object. Praise thee RnG Jesus!
	Random rand = new Random();
	
	public Stats2() {
		//stats are preset at random integers
		this.Str = rand.nextInt(15);
		this.Int = rand.nextInt(15);
		this.Dex = rand.nextInt(15);
		this.Will = rand.nextInt(15);
		this.Luck = rand.nextInt(15);
		
		//base exp for starting character
		this.Exp = 0;
		
		//Initiliazing experience requirement current max level 20
//		for(int i = 1; i < lvl.length; i++) {
//			lvl[i] = reachExp;
//			reachExp = (int) (reachExp * 1.54321);
			
//			System.out.println(lvl[i]);
//		}
		
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
		if(Exp > reachExp) {
			System.out.println("Level up!");
			lvlUp();
			
			reachExp = (int) (reachExp * 1.54321);
			
			calc = ((float)Exp/reachExp)*100;
			
			System.out.println("Progress: " + Exp + " / " +reachExp + " = " + (int)calc + "%" + " Complete! ");
			System.out.println("");
			while(Exp > reachExp) {
				
				System.out.println("Level up!");
				lvlUp();
				reachExp = (int) (reachExp * 1.54321);
				System.out.println("Progress: " + Exp + " / " + reachExp + " = " + (int)calc + "%" + " Complete! ");
				System.out.println("");
				
			}
			
		} 
		else{
			calc = ((float)Exp/reachExp)*100;
			System.out.println("Progress: " + Exp + " / " + reachExp + " = " + (int)calc + "%" + " Complete! ");
		}
			
			
		
	}
}
