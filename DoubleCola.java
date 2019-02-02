//https://www.codewars.com/kata/551dd1f424b7a4cdae0001f0/train/java

import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class DoubleCola{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    Queue<String> names = new LinkedList<>();
    System.out.println("Please enter the number of people in the Queue");
    int numberOfPeople = scan.nextInt();
    for(int i = 0; i < numberOfPeople; i++){
      System.out.println("Enter the person\'s name");
      names.add(scan.next());
    }
    System.out.println("Please enter the n-th cup");
    int nCup = scan.nextInt();
    System.out.println(getPersonWhoDrankNCup(names, nCup));
  }

  static String getPersonWhoDrankNCup(Queue people, int nCup){
    String personWhoDrank = "";
    Queue<String> names = new LinkedList<>();
    for(int i = 0; i < people.size(); i++){
      if(nCup == 0){
        return (String)people.peek();
      } else {
        String name = (String)people.poll();
        for(int j = 0; j < 2; j++){
          names.add(name);
        }
      }
      nCup = nCup - 1;
    }

    return getPersonWhoDrankNCup(names, nCup);
  }
}
