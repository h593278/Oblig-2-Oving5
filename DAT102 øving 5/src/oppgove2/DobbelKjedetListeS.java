package oppgove2;

//Ny, spesiell ordnet liste med dobbelkjeding
public class DobbelKjedetListeS<T extends Comparable<T>> {

	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetListeS(T minVerdi, T maksVerdi) {

		foerste = new DobbelNode<T>(minVerdi);
		siste = new DobbelNode<T>(maksVerdi);

		foerste.setNeste(siste);
		siste.setForrige(foerste);
		antall = 0;
	}

	public void leggTil(T ny) {
		DobbelNode<T> neste = foerste.getNeste();
		DobbelNode<T> nye = new DobbelNode<T>(ny);

		while (ny.compareTo(neste.getElement()) > 0) {
			neste = neste.getNeste();
		}
		nye.setNeste(neste);
		nye.setForrige(neste.getForrige());
		nye.getForrige().setNeste(nye);
		neste.setForrige(nye);
		antall++;

	}
	public T fjern(T x) {

		DobbelNode<T> aktuell = foerste.getNeste();
		//DobbelNode<T> sletting = new DobbelNode<T>(x);
		
		//Finner elemet som skal slettas
		while (aktuell.getElement().compareTo(x) < 0) {
			aktuell = aktuell.getNeste();
		} 
		//Vist funnet, sletter element
		if (aktuell.getElement().compareTo(x) == 0) {
			aktuell.getForrige().setNeste(aktuell.getNeste());		
			aktuell.getNeste().setForrige(aktuell.getForrige());
			antall--;
			return aktuell.getElement();
		}
		return null;
	}

	public boolean fins(T x) {
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell.getElement().compareTo(x) < 0) {
			aktuell = aktuell.getNeste();
		}
		
		if (aktuell.getElement().compareTo(x) == 0) {
			return true;
		}
		return false;
	}

	public void visListe() {
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste ) {
			System.out.println(aktuell.getElement().toString());
			aktuell = aktuell.getNeste();
		}
	}
	
	public static void main (String[] args) {
		DobbelKjedetListeS<Integer> tall = new DobbelKjedetListeS(-100, 100);
		tall.leggTil(1);
		tall.leggTil(2);
		tall.leggTil(3);
		tall.leggTil(4);
		tall.leggTil(5);
		
		tall.visListe();
		System.out.println("Finnes 5 " + tall.fins(5));
		System.out.println("Finnes 6 " + tall.fins(6));
		tall.fjern(2);
		tall.visListe();
		
	}
}// class
