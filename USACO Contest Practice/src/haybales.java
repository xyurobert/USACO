import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class haybales {
	
	public static int findMinNumber(ArrayList<Integer> s) {
		int totalHayBales = 0;
		int correctHayBales;
		int leastNumber = 0;
		for(int i = 1; i < s.size(); i++) {
			totalHayBales += s.get(i);
		}
		correctHayBales = totalHayBales / s.get(0);
		
		for(int j = 1; j < s.size(); j++) {
			if(s.get(j) > correctHayBales) {
				leastNumber += (s.get(j) - correctHayBales);
			}
		}
		return leastNumber;
	}
	
	public static void main(String args[]) {
	try {
		BufferedReader file = new BufferedReader(new FileReader("haybales.in"));
		ArrayList<Integer> list= new ArrayList<>();
		String line = file.readLine();
		while(line != null) {
			list.add(Integer.parseInt(line));
			line = file.readLine();
		}
		System.out.println(findMinNumber(list));
	} catch (IOException e){
		e.printStackTrace();
	}
	}
}
