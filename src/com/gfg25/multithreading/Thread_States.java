package com.gfg25.multithreading;

class thread implements Runnable {

	@Override
	public void run() {
		// moving thread2 to timed waiting state
		try {
			System.out.println("Moving thread2 to timed waitintg state for 15 sec");
			Thread.sleep(1500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(
				"State of thread1 while it call join() method on thread2 :: " + Thread_States.thread1.getState());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Thread_States implements Runnable {

	public static Thread thread1;
	public static Thread_States obj;

	public static void main(String[] args) {
		obj = new Thread_States();
		thread1 = new Thread(obj);
		// thread1 created and is currently in the NEW state.
		System.out.println("State of thread1 after creating it - " + thread1.getState());
		thread1.start();

		// thread1 moved to Runnable state
		System.out.println("State of thread1 after calling .start() method on it - " + thread1.getState());
		System.out.println("run() method is called for thread1");
	}

	public void run() {
		thread myThread = new thread();
		Thread thread2 = new Thread(myThread);

		// thread2 created and is currently in the NEW state.
		System.out.println("State of thread2 after creating it - " + thread2.getState());
		System.out.println("run() method is called for thread2");

		thread2.start();

		// thread2 moved to Runnable state
		System.out.println("State of thread2 after calling .start() method on it - " + thread2.getState());

		// moving thread1 to timed waiting state
		try {
			// moving thread1 to timed waiting state
			System.out.println("Moving thread1 to timed waiting state for 10sec");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("State of thread2 after calling .sleep() method on it - " + thread2.getState());

		try {
			// waiting for thread2 to die
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("State of thread2 when it has finished it's execution - " + thread2.getState());
	}

}
