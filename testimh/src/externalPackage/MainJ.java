package externalPackage;

import java.util.Random;

public class MainJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
//		Game game = new Game();
//		game.start();
		Stats test = new Stats();
		
//		test.setPts(100);
//		test.addPtsToStat();
		
		for(int i = 0; i < 40; i++) {
			test.addExp(rand.nextInt(500));
		}
		
//		test.addExp(100000);
		
	}

}
