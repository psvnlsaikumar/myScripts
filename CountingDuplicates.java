import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
public class CountingDuplicates {
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the string ");
      String text = scan.nextLine();
      System.out.println(duplicateCount(text));
    }


    public static int duplicateCount(String text) {
      text = text.toLowerCase();
      int count = 0;
      List<Character> textArr = new ArrayList<>(
        text.chars().mapToObj(e -> (char) e)
        .collect(Collectors.toList())
      );

      for(int i = 0; i < textArr.size();){
        char check = textArr.get(i);
        int isChecked = 0;
        System.out.println(textArr);
        for(int j = i + 1; j < textArr.size(); j++){
          if(check == textArr.get(j)) {
            System.out.println("for "+textArr.get(j));
            count++;
            isChecked = 1;
         textArr.removeAll(Collections.singleton(check));
          break;
        }
      }
      if(isChecked != 1){
        i++;
      }
    }
      return count;
    }
}
