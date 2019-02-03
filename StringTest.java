import java.io.*;
class StringTest{
  public static void main(String[] args){
    String x = new String("rogue");
    String y = new String("rouge");
    if(x == y){
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  static void print(String ex){
    System.out.println(ex);
  }
}
