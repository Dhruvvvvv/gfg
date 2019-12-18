package com.gfg25.multithreading;

import java.util.Scanner;
//Java program to demonstrate inter-thread communication 
// to avoid polling(continuously checking a cond unti its true) we use wait(), notify(), notifyAll()
public class WaitNotifyNotifyAll {

	public static void main(String[] args) throws InterruptedException {
		final ProducerConsumer pc= new ProducerConsumer();
        // Create a thread object that calls pc.produce() 
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		// Create another thread object that calls pc.consume()
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.comsume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});

		 // Start both threads 
        t1.start(); 
        t2.start(); 
  
        // t1 finishes before t2 

        t1.join(); 
        t2.join(); 
        
        
		

		
	}
// PC (Produce Consumer) class with produce() and consume() methods. 
    
	static class ProducerConsumer{
        // Prints a string and waits for consume() 
		public void produce() throws InterruptedException{
// synchronized block ensures only one thread  running at a time.
            synchronized (this) {
				System.out.println("Producer threading running");
                // releases the lock on shared resource 
				wait();
                // and waits till some other method invokes notify(). 
				System.out.println("Producer is resumed again..");
			}
		}
		
// Sleeps for some time and waits for a key press. After key is pressed, it notifies produce(). 
		public void comsume() throws InterruptedException{
            // this makes the produce thread to run first. 
			Thread.sleep(1000);
			@SuppressWarnings("resource")
			Scanner sc= new Scanner(System.in);
// synchronized block ensures only one thread running at a time.
			synchronized (this) {
				System.out.println("Waiting for return key to be pressed...");
				sc.nextLine();
				System.out.println("Return key pressed.!");
// notifies the produce thread that it can wake up.
				notify();
//sleep
				Thread.sleep(2000);
			}

		}

	}

}
