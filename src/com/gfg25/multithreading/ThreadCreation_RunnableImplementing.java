package com.gfg25.multithreading;

class MyThread1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Current thread: "+Thread.currentThread().getName()+" id:: "+Thread.currentThread().getId());
		
	}
	
}
public class ThreadCreation_RunnableImplementing {

	public static void main(String[] args) {
		Thread t1= new Thread(new MyThread1());
		t1.start();
		Thread t2= new Thread(new MyThread1());
		t2.start();
		Thread t3= new Thread(new MyThread1());
		t3.start();
		Thread t4= new Thread("Thread4");
		System.out.println(t4.getName().toString());
		t4.setDaemon(true);
		System.out.println("isDaemon? :: "+t4.isDaemon());
		

	}

}
