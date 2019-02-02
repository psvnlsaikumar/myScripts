import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class SimilarityMeasurement{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int query = 0;
    int numberOfQueries = 0;
    int idx = 0;
    long updatedValue = 0l;
    ArrayList<Long> arr = new ArrayList<>();
    long sizeOfArray = scan.nextLong();
    for(long i = 1; i <= sizeOfArray; i++){
      try{
        arr.add(scan.nextLong());
      }catch(Exception ex){
        ex.printStackTrace();
      }
    }

  numberOfQueries = scan.nextInt();

  for(int i = 0; i < numberOfQueries; i++){
    query = scan.nextInt();
    idx = scan.nextInt();
    switch(query){
      case 1: updatedValue = scan.nextLong(); arr = update(arr, idx, updatedValue); break;
      case 2: System.out.println(findMin(arr, idx)); break;
      default: System.out.println("Invalid Query");
      }
    }
  }

  static int findMin(ArrayList<Long> arr, int idx){
    int count = 0;
    int minIdx = idx;
    long value = arr.get(idx - 1);
    try{
    for(int i = arr.size() - 1; i >= 0; i--){
      if(value == arr.get(i) && i != idx - 1){
        minIdx =  i;
        count++;
      } else if(count > 0){
        break;
      }
    }
  }catch(Exception ex){
    ex.printStackTrace();
  }finally{
    return minIdx + 1;
  }
  }


  static ArrayList<Long> update(ArrayList<Long> arr, int idx, long updatedValue){
    try{
    arr.set(idx - 1,updatedValue);
  }catch(Exception ex){
    ex.printStackTrace();
  }finally{
        return arr;
  }
  }
}
