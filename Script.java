import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
class TestClass {
    public static void main(String args[] ) throws Exception {
      ft = new DecimalFormat("#.000000");
      Scanner scan = new Scanner(System.in);
        int totalNumberOfStudents = 0;
        int winners = 0;
        int myFavStudents = 0;
        int satisLevel = 0;
        int testCases = scan.nextInt();
        for(int i = 1; i <= testCases; i++){
          totalNumberOfStudents = scan.nextInt();
          winners = scan.nextInt();
          myFavStudents = scan.nextInt();
          satisLevel = scan.nextInt();
          System.out.println(ft.format(probablityOfHappiness(totalNumberOfStudents, winners, myFavStudents, satisLevel)));
        }
    }

    static float probablityOfHappiness(int students, int winners, int list, int satis){
      float probability = 1;
      for(int i = 0; i < list; i++){
         if(list == winners){
             return probability;
         }
      for(int i = 0; i < list; i++){
        probability = probability * (winners / students);
        students--;
        winners--;
      }
      return probability;
    }
}
}
