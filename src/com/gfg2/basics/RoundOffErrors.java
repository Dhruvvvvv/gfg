package com.gfg2.basics;

public class RoundOffErrors {

	public static void main(String[] args) {
		double a = 1.0; 
        double b = 0.10; 
        double x = 9 * b; 
        a = a - (x); 
  
        // Value of a is expected as 0.1 
        System.out.println("a = " + a); 
        
        double a1 = 1.0; 
        double b1 = 0.10; 
        double x1 = 9 * b1; 
        a1 = a1 - (x1); 
  
    /* We use Math.round() function to round the answer to 
         closest long, then we multiply and divide by 1.0 to 
         to set the decimal places to 1 place (this can be done 
         according to the requirements.*/
        System.out.println("a1 = " + Math.round(a1*1.0)/1.0); 
        

	}

}
