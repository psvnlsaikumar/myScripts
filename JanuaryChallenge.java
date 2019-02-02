import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class JanuaryChallenge{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String N = scan.nextLine();
    String setAStr = scan.nextLine();
    String setBStr = scan.nextLine();
    String[] A = setAStr.split(" ");
    String[] B = setBStr.split(" ");
    int[] setAint = new int[A.length];
    int[] setBint = new int[B.length];
    for(int i = 0; i < A.length; i++)
         setAint[i] = Integer.parseInt(A[i]);
    for(int i = 0; i < A.length; i++)
          setBint[i] = Integer.parseInt(B[i]);
    ArrayList<Integer> setA = new ArrayList<>();
    ArrayList<Integer> setB = new ArrayList<>();

    for(int i = 0; i < Integer.parseInt(N); i++){
      setA.add(setAint[i]);
    }

    for(int i = 0; i < Integer.parseInt(N); i++){
      setB.add(setBint[i]);
    }

    Collections.sort(setA);
    Collections.sort(setB);
    for(int i = 0; i < Integer.parseInt(N); i++){
      if(setA.get(i) == setB.get(i)){
        setA.remove(i);
        setB.remove(i);
      }
    }
    System.out.println(totalSteps(setA, setB));

  }

  static int totalSteps(ArrayList setA, ArrayList setB){
    int totalSteps = 0;
    for(int i = 0; i < setA.size(); i++){
        int setAx = (int) setA.get(i);
        int setBx = (int) setB.get(i);
        while(setAx != setBx){
          if(setAx > setBx){
            setAx++;
            totalSteps++;
          }
        }
    }
    return totalSteps;
  }
}
