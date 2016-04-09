package co.edu.icesi.puente;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CochesIzqda extends Thread {

	Puente puente;
	int identificador;

	public CochesIzqda(Puente puente, int identificador) {
		this.puente = puente;
		this.identificador = identificador;
	}

	public void run() {

		while (true) {

			try {

				try {
					puente.InicioSentidoIzqdaADcha();
				} catch (InterruptedException ex) {
					Logger.getLogger(CochesIzqda.class.getName()).log(Level.SEVERE, null, ex);
				}

				int t = (5);
				System.out.println("El coche de la Izquierda" + identificador + " inicia el cruce del puente de izquierda a derecha a las " + System.nanoTime());

				try {
					sleep(t*1000);
				}catch (InterruptedException e) {
				}

				puente.FinSentidoIzqdaADcha();

				System.out.println("El coche de la Izquierda" + identificador + " finaliza el cruce del puente de izquierda a derecha a las " + System.nanoTime());
			} catch (InterruptedException ex) {
				Logger.getLogger(CochesIzqda.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
