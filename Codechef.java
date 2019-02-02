	import java.util.*;
	import java.lang.*;
	import java.io.*;
	import java.util.Scanner;

	class Codechef
	{
		public static void main (String[] args) throws java.lang.Exception{
			int testCases = 0;
			Scanner scan = new Scanner(System.in);
			testCases = scan.nextInt();
			char row1[] = new char[9];
			int innerSum = 0;
			for(int x = 0; x < testCases; x++){
					innerSum = 0;

					StringBuilder sb = new StringBuilder();
					scan.next();
					sb.append(scan.next());
					sb.append(scan.next());
					sb.append(scan.next());

					char[] row2 = sb.toString().toCharArray();
					row1 = row2;
					for(int i = 0; i < row1.length; i++){
							if(row1[i] == 'l'){
								row1[i] = 1;
							} else {
								row1[i] = 0;
							}
					}
					for(int i = 0; i < row1.length - 1; i++){
						try{
						if(row1[i] == 1){
							int buffSum = row1[i] + row1[i + 3] + row1[i + 4];
							if(buffSum == 3){
								innerSum = buffSum;
							}
						}
					}catch(Exception e){

					}
				}
				if(innerSum == 3){
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}

		}
	}
