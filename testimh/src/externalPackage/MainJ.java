package externalPackage;

import java.util.Random;

public class MainJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
//		Game game = new Game();
//		game.start();
		
		Attributes tester = new Attributes();
//		Stats test = new Stats();
//		tester.setPts(100);
//		tester.addPtsToStat();
//		
//		test.setPts(100);
//		test.addPtsToStat();
		
		
		for(int i = 0; i < 50; i++) {
			tester.addExp(rand.nextInt(5000));

				tester.updateMaxAttributes();
		}
		
//		tester.getStats();
//		tester.getCondition();
//		test.addExp(500);
//		test.addExp(500);
//		tester.addExp(500);
//		tester.addExp(500);
//		test.addExp(5000);
		tester.addExp(5000000);
//		tester.getStats();
		tester.updateMaxAttributes(tester.getLevelLooper());
		tester.getCondition();
//		test.getExpRequirements();
	}

}
