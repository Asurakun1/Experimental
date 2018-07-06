package externalPackage;

import java.util.Formatter;
import java.util.Random;

/*
 * This is the sub class of the Stats class
 * this is intended to set the attributes to the players stat system. such as vitaility, mana and stamina
 * It will not only be additional stats to the player but it will also be intended for setting buffs and debuffs
 * This will not calculate the amount of damage based on stats.
 */

public class Attributes extends Stats{
	
	/*
	 * Psudeo code for now
	 * 
	 * Hp, mp, stam
	 * 
	 * status effects variables such as bleeding, poisoning, nausea, burning, curse, silence, etc. try not to go over board you damn brain
	 * 
	 * Attributes() empty constructor for now maybe initialize hp mp and stam variables.
	 * 
	 * getCondition() gets the hp mp and stam. post to console in future
	 * 
	 * 
	 * status effects section for buffs and debuffs
	 * 
	 */

	private int Vitality,minVitality,maxVitality;
	private int Mana,minMana,maxMana;
	private int Stamina,minStamina,maxStamina;
	
	public Attributes() {
		
		//base stats of the very start
		
		maxVitality = 10;
		maxMana = 10;
		maxStamina = 10;
	}
	
	public void getCondition() {
		
		System.out.println("\nCurrent Condition: \n"
				+ "------------------");
		System.out.printf("Vitality : | %1d ", Vitality);
		System.out.printf("/ %1d | \n", maxVitality);
		
		System.out.printf("Mana     : | %1d ", Mana);
		System.out.printf("/ %1d | \n", maxMana);
		
		System.out.printf("Stamina  : | %1d ", Stamina);
		System.out.printf("/ %1d | \n", maxStamina);
		
		System.out.println("------------------");
	}
	
	public void getConditionInfo(){
		
		//strFormat.format("|%-20d|", output);
		
		System.out.println("\nCurrent Condition: \n"
				+ "------------------");
		System.out.printf("Vitality : | %1d ", Vitality);
		System.out.printf("/ %1d | \n", maxVitality);
		
		System.out.printf("Mana     : | %1d ", Mana);
		System.out.printf("/ %1d | \n", maxMana);
		
		System.out.printf("Stamina  : | %1d ", Stamina);
		System.out.printf("/ %1d | \n", maxStamina);
		
		System.out.println("------------------");
		System.out.println("Vitality is affected by your Strength. The more strength you have the more health and defense you will gain. \n"
				+ "\nMana is affected by your Intelligence. The more Intelligence you have the more mana and magic defense you will have.\n"
				+ "\nStamina is affected by your Dexterity. The more Dexterity you have the more energy you will have.");
	}
	
	
	public void updateByStatPts() {
		int hpCalc = this.getStr()/5;
		int mpCalc = this.getInt()/7;
		int spCalc = this.getDex()/6;
		maxVitality =  maxVitality + hpCalc;
		maxMana = maxMana + mpCalc;
		maxStamina = maxStamina + spCalc;
	
		Vitality = maxVitality;
		Mana = maxMana;
		Stamina = maxStamina;
	}
	
	public void updateMaxAttributes() {
		
		if(this.hasLeveled()) {
			int hpCalc = this.getStr()/5;
			int mpCalc = this.getInt()/7;
			int spCalc = this.getDex()/6;
			maxVitality =  maxVitality + hpCalc;
			maxMana = maxMana + mpCalc;
			maxStamina = maxStamina + spCalc;
		
			Vitality = maxVitality;
			Mana = maxMana;
			Stamina = maxStamina;
		}
	}
	
	public void updateMaxAttributes(int levelsPassed) {
		
		if(this.hasLeveled()) {
			
			for(int i = 0; i < levelsPassed; i++) {
				int hpCalc = this.getStr()/5;
				int mpCalc = this.getInt()/7;
				int spCalc = this.getDex()/6;
				maxVitality =  maxVitality + hpCalc;
				maxMana = maxMana + mpCalc;
				maxStamina = maxStamina + spCalc;
		
				Vitality = maxVitality;
				Mana = maxMana;
				Stamina = maxStamina;
			}
		}
	}
	
	public void takeDmg() {
		Random rand = new Random();
		int dmg = (rand.nextInt(5) + 1);
		System.out.println("You've taken " + dmg + " damage!");
		Vitality = Vitality - dmg;
	}
	

}
