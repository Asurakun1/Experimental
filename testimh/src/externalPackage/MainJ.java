package externalPackage;

import java.util.Random;

public class MainJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stats newChar = new Stats();
		
		Random rando = new Random();
		
		newChar.getStats();
//		newChar.addExp(90000);
		for(int i = 0; i < 60; i++) {
			newChar.addExp((int) (rando.nextInt(200)));
		}
	}

}
