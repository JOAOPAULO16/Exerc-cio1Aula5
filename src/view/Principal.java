package view;

import java.util.concurrent.Semaphore;

import controller.Porta;

public class Principal {
	
	public static void main (String [] args) {
		
		int perm = 1;
		Semaphore semaforo = new Semaphore(perm);
		
		for (int pessoa = 1; pessoa <= 4; pessoa++) {
			Thread Porta = new Porta(pessoa, semaforo);
			Porta.start();
		}		
	}
}
