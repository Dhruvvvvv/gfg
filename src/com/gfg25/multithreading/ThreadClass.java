package com.gfg25.multithreading;

//Java program to demonstrate method calls of Thread class
class Helper implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("Thread-2 is going to sleep from 15sec...");
			Thread.sleep(15000);
			
		}catch(InterruptedException e) {
		 System.out.println("Thread-2 interrupted.");
		}
	}
}
public class ThreadClass implements Runnable{
	@Override
	public void run() {
		
	}
	public static void main(String[] args) {
		ThreadClass obj1= new ThreadClass();
		Helper h= new Helper();
		Thread thread1 = new Thread(obj1);
		Thread thread2 = new Thread(h); 
		

	}

	

}
