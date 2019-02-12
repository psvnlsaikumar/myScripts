import java.io.*;
import java.util.Scanner;

public class Collatz{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number");
		System.out.println(collatz(scan.nextInt()));
	}


	public static String collatz(int n) {
		String path = String.valueOf(n);
		int count = 0;
		 while(!(n == 1)){	
		    if(n % 2 == 0){
		    	n = (n/2);
		    } else {
		    	n = (3 * n) + 1;
		    }
		    	path += "->" + n;
		    	count++;
		  }
		  System.out.println(count +" Steps have occured");
		  return path;
		}
		
}