import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EnergyComsumptionHackerEarth{
    public void calcEnergy(){

    }
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int numCities  = scan.nextInt();
      Long[] EnergyReqd = new Long[numCities];
      Long totalEnergy = 0l;
      long maximum = 0;
      for(int i = 0; i < numCities; i++){
        EnergyReqd[i] = scan.nextLong();
        totalEnergy += EnergyReqd[i];
        if(maximum < EnergyReqd[i]){
          maximum = EnergyReqd[i];
        }
      }
      System.out.println(totalEnergy - maximum);
    }
  }
