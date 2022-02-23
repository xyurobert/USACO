/*
ID: xyu.rob1
LANG: JAVA
PROG: friday
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class friday {
	public static void main(String args[]) {
		try {	
			BufferedReader file = new BufferedReader(new FileReader("friday.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
			int year = Integer.parseInt(file.readLine());
			int day = 1;
			int[] array1 = new int[] {0,0,0,0,0,0,0};
			
			
			for(int i = 0; i < year; i++) {							
				
				array1[(day+12)%7]++;//january
				day+=12;
				array1[(day+31)%7]++;//february
				day+=31;
				if((1900+i)%4 == 0 && (((1900+i)%100 == 0 && ((1900+i)%400 != 0)))) {//march
					array1[(day+28)%7]++;
					day+=28;
				} else if((1900+i)%4 == 0 && (((1900+i)%100 == 0 && ((1900+i)%400 == 0)))) {
					array1[(day+29)%7]++;
					day+=29;
				} else if((1900+i)%4 == 0) {
					array1[(day+29)%7]++;
					day+=29;
				} else {
					array1[(day+28)%7]++;
					day+=28;
				}
				array1[(day+31)%7]++;//april
				day+=31;
				array1[(day+30)%7]++;//may
				day+=30;
				array1[(day+31)%7]++;//june
				day+=31;
				array1[(day+30)%7]++;//july
				day+=30;
				array1[(day+31)%7]++;//august
				day+=31;
				array1[(day+31)%7]++;//september
				day+=31;
				array1[(day+30)%7]++;//october
				day+=30;
				array1[(day+31)%7]++;//november
				day+=31;
				array1[(day+30)%7]++;//december
				day+=42;
				System.out.println("Day Count: " + day);
				System.out.println(Arrays.toString(array1));
			}
			
			
			
			
			int[] array2 = new int[] {0,0,0,0,0,0,0};
			int[] index = new int[] {1,2,3,4,5,6,0};
			int[] temp = new int[array1.length];
			array2 = array1;
			
			for(int i = 0; i<array2.length; i++) {
				temp[index[i]] = array2[i];
			}
			for (int i = 0; i<array2.length; i++)
	        {
	           array2[i] = temp[i];
	           index[i] = i;
	        }
			
			for(int i = 0; i < array2.length; i++) {
				if((i+1) == array2.length) {
					out.println(array2[i]);
					break;
				}
				out.print(array2[i] + " ");
			}
			
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
