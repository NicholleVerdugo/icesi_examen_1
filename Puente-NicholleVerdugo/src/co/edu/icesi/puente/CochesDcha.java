package co.edu.icesi.puente;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CochesDcha extends Thread {

	Puente puente;
	int identificador;

	public CochesDcha(Puente puente, int identificador) {
		this.puente = puente;
		this.identificador = identificador;
	}

	public void run() {

		while (true) {

			try {
				puente.InicioSentidoDchaAIzqda();
			} catch (InterruptedException ex) {
				Logger.getLogger(CochesDcha.class.getName()).log(Level.SEVERE, null, ex);
			}

			int t = (5);
			System.out.println("El coche de la derecha" + identificador + " inicia el cruce del puente de derecha a izquierda a las " + System.nanoTime());


			try {
				sleep(t * 1000);
			} catch (InterruptedException e) {
			}

			try {
				puente.FinSentidoDchaAIzqda();
			} catch (InterruptedException ex) {
				Logger.getLogger(CochesDcha.class.getName()).log(Level.SEVERE, null, ex);
			}

			System.out.println("El coche de la derecha" + identificador + " finaliza el cruce del puente de derecha a izquierda a las " + System.nanoTime());

		}

	}
}
