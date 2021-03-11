package oppgove1;

public class Rekrusjon {

	// Oppgåve a)
	public static int sum(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sum(n - 1);
	}

	// Oppgåve b)
	public static int a(int n) {
		if (n == 0) {
			return 2;
		}
		if (n == 1) {
			return 5;
		}
		return 2 * a(n - 1) - 6 * a(n - 2) + 2;
	}

	public static void main(String[] args) {
		System.out.println("oppgåve 1a)");
		System.out.println(sum(100));
		
		System.out.println("oppgåve 1b)");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " = " + a(i));
		}
		/*
		TowersOfHanoi tower = new TowersOfHanoi(28);
		Long start1 = System.currentTimeMillis();
		tower.solve();
		System.out.println("Tidsbruket ved å fytte 28 ringer er: " + (System.currentTimeMillis()-start1));
		System.out.println("Antall flyttninger: " + tower.getAntall());
		*/
		
		//oppgåve 1c)
		System.out.println("oppgåve 1c)");
		TowersOfHanoi tower1 = new TowersOfHanoi(28);
		long start = System.currentTimeMillis();
		tower1.solve();
		System.out.println("Antall flyttinger med 28 ringer er: " + tower1.getAntall());
		System.out.println("Tidsbruk på 28 er: " + (System.currentTimeMillis()-start) + "ms");

		
		TowersOfHanoi tower2 = new TowersOfHanoi(29);
		start = System.currentTimeMillis();
		tower2.solve();
		System.out.println("Antall flyttinger med 29 ringer er: " + tower2.getAntall());
		System.out.println("Tidsbruk på 29 er: " + (System.currentTimeMillis()-start) + "ms");

		
		TowersOfHanoi tower3 = new TowersOfHanoi(30);
		start = System.currentTimeMillis();
		tower3.solve();
		System.out.println("Antall flyttinger med 30 ringer er: " + tower3.getAntall());
		System.out.println("Tidsbruk på 30 er: " + (System.currentTimeMillis()-start) + "ms");

	}
}
