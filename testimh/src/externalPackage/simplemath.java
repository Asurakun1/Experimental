/*
 * Dont worry about this at all. this has nothing to do with the project.
 * It's just in here for more tinkering.
 * @author: Asurakun1
 */
package externalPackage;
import java.util.Random;

public class simplemath {
	//random object for rng
	Random rand = new Random();
	//initialized variables
	private int gen1, gen2, solve, state;

	public simplemath() {
		//sets a random number to gen1 and gen2
		gen1 = rand.nextInt(10);
		gen2 = rand.nextInt(10);
	}
	
	public simplemath(int ex1, int ex2) {
		this.gen1 = ex1;
		this.gen2 = ex2;
	}
	
	public int addition() {
		solve = gen1 + gen2;
		state = 1;
		return solve;
	}
	
	public int subtraction() {
		solve = gen1 - gen2;
		state = 2;
		return solve;
	}
	
	public int getGen1() {
		return gen1;
	}
	
	public int getGen2() {
		return gen2;
	}

	public void Post() {
		if(state == 1) {
			System.out.println(getGen1() + " + " + getGen2() + " = " + solve); 
		} 
		
		if(state == 2) {
			System.out.println(getGen1() + " - " + getGen2() + " = " + solve); 
		}
	}
	
	public void postRepeater() {
		int temp = 0;
		if(gen1 > gen2) {
			temp = gen1;
		}
		
		if(gen1 < gen2) {
			temp = gen2;
		}
		
		if(state == 1) {
		
			for(int i = 0; i <= temp; i++) {
				addition();
				Post();
				gen1--;
				gen2--;
			}
		}
		
		if(state == 2) {
			for(int i = 0; i <= temp; i++) {
				subtraction();
				Post();
				gen1--;
				gen2--;
			}
		}
		
		gen1 = rand.nextInt(10);
		gen2 = rand.nextInt(10);
	}
}
