package com.gfg25.multithreading;

class MyThread extends Thread{
	public void run() {
		System.out.println("Current thread name: "+Thread.currentThread().getName()+" and it's id:: "+Thread.currentThread().getId());
		
	}
}
public class ThreadCreation_ThreadclassExtend {

	public static void main(String[] args) {
		int n=5;
		for(int i=0;i<5;i++) {
		MyThread t1= new MyThread();
		t1.start();
		}

	}

}
