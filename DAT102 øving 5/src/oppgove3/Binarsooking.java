package oppgove3;

public class Binarsooking {
	public static void main(String[] args) {
		Integer[] tab = {2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31};
		System.out.println(binarSooking(tab, 31, 0, tab.length-1));

	}

	public static <T extends Comparable<T>> int binarSooking(T[] tab, T sookeTall, int start, int slutt) {
		int svar = -1;
		int midten = (start + slutt)/2; 
		
		//Basis
		if (start>=slutt) {
			if (sookeTall.compareTo(tab[midten]) == 0) {
				svar = midten;
				System.out.println("Funnet");
			}
		}
		
		//Rekrusivt kall
		else if (sookeTall.compareTo(tab[midten]) > 0) {
			svar = binarSooking(tab, sookeTall, midten+1, slutt);
			System.out.println("H");
			System.out.println(midten);


		} else {
			svar = binarSooking(tab, sookeTall, start, midten);
			System.out.println("V");
		}
		return svar;
	}
}
