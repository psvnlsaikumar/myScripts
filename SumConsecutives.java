import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class SumConsecutives{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

  }

  static List<Integer> sumConsecutives(List<Integer> s) {
       List<Integer> temp = new ArrayList<>();
       int isSame = -1;
       int j = 0, sum = 0;
       for(int i = 0; i < s.size(); i++){
         try{
        if(s.get(i) == s.get(i + 1)){
         sum += s.get(i);
       }else{
         temp.add(j, sum);
         sum = 0;
         j++;
       }
     }catch(Exception ex){
       ex.printStackTrace();
     }
      }
       return temp;
   }
}
