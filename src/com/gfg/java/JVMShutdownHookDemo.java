package com.gfg.java;

public class JVMShutdownHookDemo {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Shutdown hook is running before JVM is shutting down");
			}
		});
		System.out.println("Application is terminating");

	}
	// Shutdown Hooks are a special construct that allows developers to plug in a
	// piece of code to be executed when the JVM is shutting down.
	// This comes in handy in cases where we need to do special clean up operations
	// in case the VM is shutting down.
	/*
	 * The first thing to keep in mind is that it is not guaranteed that shutdown
	 * hooks will always run. If the JVM crashes due to some internal error, then it
	 * might crash down without having a chance to execute a single instruction.
	 * Also, if the O/S gives a SIGKILL (http://en.wikipedia.org/wiki/SIGKILL)
	 * signal (kill -9 in Unix/Linux) or TerminateProcess (Windows),
	 * 
	 * 
	 * 
	 * 1. It is also possible to terminate the JVM without allowing the shutdown
	 * hooks to run by calling Runtime.halt() method. Shutdown hooks are called when
	 * the application terminates normally (when all threads finish, or when
	 * System.exit(0) is called.
	 * 
	 * 
	 * 2. Once started, Shutdown Hooks can be forcibly stopped before completion.
	 * 
	 * 
	 * 3. We can have more than one Shutdown Hooks, but their execution order is not
	 * guaranteed.
	 * 
	 * 
	 * 4. We cannot register/unregister Shutdown Hooks within Shutdown Hooks Once
	 * the shutdown sequence is initiated by the JVM, it is not allowed to add more
	 * or remove any existing shutdown hooks. If this is attempted, the JVM throws
	 * IllegalStateException.
	 * 
	 * 5. Once shutdown sequence starts, it can be stopped by Runtime.halt()
	 * only.Once the shutdown sequence starts, only Runtime.halt() (which forcefully
	 * terminates the JVM) can stop the execution of the shutdown sequence (except
	 * for external influences such as SIGKILL). This means that calling
	 * System.exit() within a Shutdown Hook will not work. Actually, if you call
	 * System.exit() within a Shutdown Hook, the VM may get stuck, and we may have
	 * to terminate the process forcefully.
	 * 
	 * 6. Using shutdown hooks require security permissions. If we are using Java
	 * Security Managers, then the code which performs adding/removing of shutdown
	 * hooks need to have the shutdownHooks permission at runtime. If we invoke this
	 * method without permission in a secure environment, then it will result in
	 * SecurityException.
	 *
	 */
}
