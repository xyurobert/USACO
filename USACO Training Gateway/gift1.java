/*
ID: xyu.rob1
LANG: JAVA
PROG: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class gift1 {
	
	public static HashMap<String, Integer> getNames(ArrayList<String> s) {
		int numberOfPeople = Integer.parseInt(s.get(0));
		LinkedHashMap<String, Integer> map =  new LinkedHashMap<>();
		for(int i = 1; i < numberOfPeople+1; i++) {
			map.put(s.get(i), 0);
		}
		return map;
	}
	
	public static HashMap<String, Integer> calculate(ArrayList<String> a, HashMap<String, Integer> b, int c) {
	for(int i = 0; i < c; i++) {
		String str = a.get(1);
		String cashString;
		String people;
		int cashStringInt;
		int peopleInt;
		cashString = str.substring(0, str.indexOf(" "));
		people = str.substring(str.indexOf(" ")+1, str.length());
		cashStringInt = Integer.parseInt(cashString); //convert to int
		peopleInt = Integer.parseInt(people); //convert to int

		if(peopleInt == 0) {
			b.put(a.get(0), (b.get(a.get(0)))); //if person is giving money to nobody
		} else {
		b.put(a.get(0), (b.get(a.get(0)) - cashStringInt) + (cashStringInt%peopleInt)); //person giving out the money
		} 
		for(int j = 2; j < 2+peopleInt; j++) { //money going to people
			b.put(a.get(j), b.get(a.get(j))+(cashStringInt/peopleInt));
		}
		for(int k = 0; k < peopleInt+2; k++) {
			a.remove(0);
		}
		}
	return b;
	}
	
	public static void main(String args[]) {
		try {
			BufferedReader file = new BufferedReader(new FileReader("gift1.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
			ArrayList<String> list = new ArrayList<>();
			ArrayList<String> updatedList = new ArrayList<>();
			String line = file.readLine();
			HashMap<String, Integer> finalMap = new HashMap<>();
			int finalMapSize;
			while(line != null) {
				list.add(line);
				line = file.readLine();
			}
			
			int numberOfPeople = Integer.parseInt(list.get(0));
			for(int i = numberOfPeople+1; i < list.size(); i++) {
				updatedList.add(list.get(i));
			}
			finalMap = calculate(updatedList, getNames(list), numberOfPeople);
			
			for(String key : finalMap.keySet()) {
				out.println(key + " " + finalMap.get(key));
			}
			
			out.close();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
