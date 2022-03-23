package controller;

import java.util.concurrent.Semaphore;

public class Porta extends Thread {
	
	private int pessoa;
	private Semaphore door;
	
	public Porta (int pessoa, Semaphore door) {
		this.door = door;
		this.pessoa = pessoa;
	}
	
	public void run() {
		
		andar();
		try {
			System.out.println("Pessoa #" + pessoa + " entrou na porta");
			door.acquire();
			Thread.sleep((int) (Math.random()*1000) + 1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			door.release();
			pessoasaiu();
		}
	
	}
	public void andar() {
		
		int dist = 0;
		System.out.println("Pessoa #" + pessoa + " está andando no corredor");
		
		while (dist < 200) {
			dist += (int) (Math.random()*2) + 4;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void pessoasaiu() {
		System.out.println("Pessoa #" + pessoa + " saiu da porta");
	}

}
