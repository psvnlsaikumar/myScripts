import java.io.*;
import java.util.Scanner;
import java.util.Arrays;


public class PrimeNodes{

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int nodes = scan.nextInt();
    int[][] tree = new int[nodes][nodes];
    int roots[] = new int[nodes];
    int countPrime = 0;



    for(int i = 0; i < roots.length - 1; i++){
      roots[i] = 0;
    }
    roots[0] = 1;

    for(int i = 0; i < nodes - 1; i++){
      int parent = scan.nextInt();
      roots[parent] += scan.nextInt();
    }

    for(int e: roots){
      if(e != 0 && e != 1){
      int temp;
    	boolean isPrime=true;
  	  for(int i=2;i<=e/2;i++)
  	     {
             temp=e%i;
  	          if(temp==0)
  	   {
  	      isPrime=false;
  	      break;
  	   }
  	}
  	if(isPrime)
  	   countPrime++;
     }
   }

      System.out.println(countPrime);

  }
}
