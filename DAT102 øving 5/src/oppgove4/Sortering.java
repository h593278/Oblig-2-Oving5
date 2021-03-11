package oppgove4;

import java.util.Random;

public class Sortering {
	/**
	 * Utvalgssortering
	 * 
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgsSortering(T[] data) {
		int minstePos;
		for (int i = 0; i < data.length - 1; i++) {
			minstePos = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j].compareTo(data[minstePos]) < 0) {
					minstePos = j;
				}
			}

			// byte om
			T tmp = data[i];
			data[i] = data[minstePos];
			data[minstePos] = tmp;
		}
	}

	public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {
		for (int i = 1; i < data.length; i++) {
			T nokkel = data[i];
			int p = i;

			while (p > 0 && nokkel.compareTo(data[p - 1]) < 0) {
				data[p] = data[p - 1];
				p--;
			}

			data[p] = nokkel;
		}
	}

	public static <T extends Comparable<T>> void bobleSortering(T[] data) {
		for (int siste = data.length - 1; siste > 0; siste--) {
			for (int i = 0; i < siste; i++) {
				if (data[i].compareTo(data[i + 1]) > 0) {
					T tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				}
			}
		}

	}

	private static <T> void swap(T[] tab, int i, int j) {
		T tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
	}

	private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
		T temp, pivot;
		int midten = (min + maks) / 2;
		pivot = data[midten];
		swap(data, midten, min); // bytter om første og midtelementet

		int venstre = min + 1;
		int hoyre = maks;
		while (venstre < hoyre) {// ytre løkke

			/** Søker et element som er > enn pivot */
			/** Sikrer at partisjoneringsprosessen vil fortsette så lenge venstre < hoyre */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			
			/** Søker et element som er <= enn pivot */
			while (data[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}

			/** bytter elementene desom venstre er mindre enn hoyre */
			if (venstre < hoyre) {
				swap(data, venstre, hoyre);
			}

		} // while – ytre løkke

		/** flytter pivot til riktig og sin endelige plass */

		swap(data, min, hoyre);

		return hoyre;

	}// metode

	public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {

		// basis: 0 eller 1 element -> gjer ingenting

		if (min < maks) { // minst to element
			int posPivot = finnPartisjon(data, min, maks);
			// sorter venstre del
			kvikkSort(data, min, posPivot - 1);
			// sorter høgre del
			kvikkSort(data, posPivot + 1, maks);
		}
	}

	// Kvikksort ny
	public static <T extends Comparable<T>> void kvikkSortNy(T[] data) {
		kvikkSortNy(data, 0, data.length - 1);
		sorteringVedInnsetting(data);
	}

	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
		final int MIN = 70;
		int posPartisjon;
		if (maks - min + 1 > MIN) {// antall elementer > MIN ?
			posPartisjon = finnPartisjon(data, min, maks);
			kvikkSortNy(data, min, posPartisjon - 1);
			kvikkSortNy(data, posPartisjon + 1, maks);
		}

	}// metode

	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		/*
		 * Fletter to sorterte deltabeller, tabell[forste,midten] og
		 * tabell[midten+1,siste] til en sortert tabell Forkrav: forste <= midten <=
		 * siste Deltabellene tabell[forste … midten] og tabell[midten+1 … siste] er
		 * hver sorterte i ikke- avtagende rekkefølge.
		 * 
		 * ResultatTabell[forste … siste] er sortert.
		 * 
		 * Implementasjon : Denne metoden fletter to deltabeller til en hjelpetabell og
		 * kopierer resultatet til den originale tabellen.
		 */

		int storrelse = siste - forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[storrelse]);

		int forsteV = forste;
		int sisteV = midten;
		int forsteH = midten + 1;
		int sisteH = siste;

		// indeks i hjelp
		int h = 0;

		while (forsteV <= sisteV && forsteH <= sisteH) {
			if (tabell[forsteV].compareTo(tabell[forsteH]) <= 0) {
				hjelpeTabell[h] = tabell[forsteV];
				forsteV++;
			} else {
				hjelpeTabell[h] = tabell[forsteH];
				forsteH++;
			}
			h++;
		}

		// kopiere resten av venstre del (kan være tom)
		while (forsteV <= sisteV) {
			hjelpeTabell[h] = tabell[forsteV];
			forsteV++;
			h++;
		} // while

		// kopiere resten av høyre del (kan være tom)
		while (forsteH <= sisteH) {
			hjelpeTabell[h] = tabell[forsteH];
			forsteH++;
			h++;
		} // while

		// Kopier resultatet tilbake til den originale tabellen
		h = 0;
		for (int indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h];
			h++;
		}
	}// flette */

	public static <T extends Comparable<T>> void fletteSort(T[] tabell, int forste, int siste) {
		// basis: 1 element - > gjer ingenting
		if (forste < siste) { // minst to element
			int midten = (forste + siste) / 2;
			fletteSort(tabell, forste, midten);
			fletteSort(tabell, midten + 1, siste);
			flette(tabell, forste, midten, siste);
		}
	}

	public static void main(String[] args) {
//		Integer[] tab = { 7, 3, 1, 9, 2, 4, 10, 37, 0 };
		Integer[] tab = { 1,1,1,1,1,1,1 };

		//utvalgsSortering(tab);
		// sorteringVedInnsetting(tab);
		// bobleSortering(tab);
		// fletteSort(tab, 0, tab.length - 1);
		 kvikkSort(tab, 0, tab.length - 1);
		//kvikkSortNy(tab);

		for (Integer e : tab) {
			System.out.print(e + " ");
		}

		System.out.println();
		int n = 1000;
		int antal = 10;
		
		//Random tilfeldig = new Random();
		
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				//a[i][j] = tilfeldig.nextInt();
				a[i][j] = 1;
				//a[i][j] = n-j;
			}
		}
		// start tidsmåling
		long tid = System.nanoTime();
		for (int i = 0; i < antal; i++) {
			kvikkSort(a[i], 0,  a[i].length-1); // blir ein eindimensjonal tabell
		}
		tid = System.nanoTime()-tid;
		
		System.out.println(tid/antal);
		System.out.println("C = " + (tid/antal)/(n*Math.log(n)/Math.log(2)));
		
	}

	public static int[] tilfeldiTalTab(int storrelse) {

		Random tilfeldig = new Random();
		int[] tab = new int[storrelse];

		for (int i = 0; i < storrelse; i++) {
			tab[i] = tilfeldig.nextInt();
		}
		return tab;
	}
}
