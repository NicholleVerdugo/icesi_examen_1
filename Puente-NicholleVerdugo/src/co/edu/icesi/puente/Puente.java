package co.edu.icesi.puente;

import java.util.concurrent.Semaphore;


public class Puente {

	int numCoches;//Contador de los coches. Recurso compartido.

	Semaphore mutexNumCoches; //Semáforo que regula la variable numCoches

	Semaphore maxCoches; // Semáforo que representa el peso máximo que soporta el puente, en este caso el número máximo son 10 coches simultáneamente.

	Semaphore puente; // Semáforo que representa el puente

	Semaphore sentido; // Semáforo que representa el sentido. En un momento dado sólo se permite a los coches cruzar en un mismo sentido de circulación. 

	public Puente() {
		numCoches = 0;
		mutexNumCoches = new Semaphore(1, true);
		maxCoches = new Semaphore(10,true); // Número máximo de Coches en un sentido y tiempo dado. 
		puente = new Semaphore(1, true);
		sentido = new Semaphore(1, true);

	}

	public void InicioSentidoDchaAIzqda() throws InterruptedException {
		sentido.acquire(); //Si ya los coches de la derecha lo están usando no puede aumentar los Coches de la izquierda
		maxCoches.acquire(); //Se adquiere la capacidad máxima de coches que puede soportar el puente, para iniciar la ejecución
		mutexNumCoches.acquire();
		numCoches ++;
		if (numCoches == 1) {
			puente.acquire();
		}
		mutexNumCoches.release(); //Debe ir adentro el acquire sino, alguien podria aumentar a los coches de la izquierda
		sentido.release();
	}

	public void FinSentidoDchaAIzqda() throws InterruptedException {
		mutexNumCoches.acquire();
		numCoches --;
		mutexNumCoches.release();
		if (numCoches == 0) { // Si esta adentro se da mas importancia a los Coches de la izquierda
			puente.release();
			maxCoches.release();
		}

	}

	public void InicioSentidoIzqdaADcha() throws InterruptedException {
		sentido.acquire();
		maxCoches.acquire();
		mutexNumCoches.acquire();
		numCoches ++;
		if (numCoches == 1) {
			puente.acquire();
		}
		mutexNumCoches.release();//Debe ir adentro el acquire sino, alguien podria aumentar los Coches de la derecha
		sentido.release();
	}

	public void FinSentidoIzqdaADcha() throws InterruptedException {
		mutexNumCoches.acquire(); // Variable que regula a la variable numCoches
		numCoches --;
		mutexNumCoches.release();
		if (numCoches == 0) { // Si esta adentro se da mas importancia a los Coches de la derecha
			puente.release(); // Se libera el recurso de puente para que pueda ser adquirido por el otro sentido
			maxCoches.release(); // Se libera la cantidad, es decir, que aumenta la cantidad del maximo de coches para el otro sentido
		}



	}
}
