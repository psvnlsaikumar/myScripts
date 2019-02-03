import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class Consecutives{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    List<Integer> s = new ArrayList<>();
    int listSize = 0;
    System.out.println("Please enter the size of the List");
    listSize = scan.nextInt();
    for(int i = 0; i < listSize; i++){
      System.out.println("Enter the item in the list");
      s.add(scan.nextInt());
    }
    System.out.println("The List is \n" + s);

    System.out.println(consecutiveAddition(s));
  }

  static List<Integer> consecutiveAddition(List<Integer> s){
    List<Integer> consList = new ArrayList<>();
    int j = 0;
    int similarEle = s.get(0);
    consList.add(similarEle);

    for(int i = 1; i < s.size(); i++){
      if(similarEle == s.get(i)){
        consList.set(j, consList.get(j) + s.get(i));
      } else {
        j = j + 1;
        consList.add(j, s.get(i));
        similarEle = s.get(i);
      }
    }
    return consList;
  }
}
