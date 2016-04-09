package co.edu.icesi.puente;

public class Test {

	public static void main(String args[]) {

		Puente p = new Puente();
		
		for (int i = 1; i < 11; i++) {
			CochesIzqda p1 = new CochesIzqda(p,i);
			p1.start();
		}
		
		for (int i = 1; i < 11; i++) {
			CochesDcha p2 = new CochesDcha(p, i);
			p2.start();
		}

	}
}
