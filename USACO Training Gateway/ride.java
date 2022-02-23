/*
ID: xyu.rob1
LANG: JAVA
PROG: ride
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
	public static int calculateValue(String s) {
		int totalValue = 1;
		for(int i = 0; i < s.length(); i++) {
			char character = s.charAt(i);
			int value = ((int) character) - 64;
			totalValue = totalValue * value;
		}
		return totalValue;
	}
	
	public static String decision(String a, String b) {
		if(calculateValue(a)%47 == calculateValue(b) % 47) {
			return("GO");
		} else {
			return("STAY");
		}
	}
	public static void main(String args[]) {
	try {	
		BufferedReader file = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String groupName = file.readLine();
		String cometName = file.readLine();
		out.println(decision(groupName, cometName));
		out.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
