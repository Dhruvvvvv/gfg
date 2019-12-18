package com.gfg25.multithreading;

class ChildThread extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("Child thread is executing");
		}
	}
}

public class MainThread {

	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		System.out.println("Current thread name :: " + t1.getName());
		System.out.println("Current thread priority :: " + t1.getPriority());
		t1.setName("Main_Thread");
		System.out.println("Current thread new name :: " + t1.getName());
		t1.setPriority(10);
		System.out.println("Current thread priority :: " + t1.getPriority());
		for (int i = 0; i <= 5; i++) {
			System.out.println("Thread " + "'" + t1.getName() + "'" + " is executing..!");
		}
		t1.setPriority(5);
		ChildThread ct = new ChildThread();
		System.out.println("ChildThread name: " + ct.getName());
		ct.setName("Child_Thread");
		System.out.println("ChildThread new name: " + ct.getName());
		ct.start();
		System.out.println("ChildThread priority:: " + ct.getPriority());
		ct.setPriority(1);
		System.out.println("ChildThread new priority:: " + ct.getPriority());
	}

}
