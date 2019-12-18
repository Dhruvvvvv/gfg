package com.gfg25.multithreading;

public class MainThreadDeadLoack {

	public static void main(String[] args) {
		System.out.println("Main Thread");
		try {
			System.out.println("Calling join on main thread itself");
			Thread.currentThread().join();
			 // the following statement will never execute 
            System.out.println("This statement will never execute"); 
             
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}

	}

}
