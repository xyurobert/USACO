import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class marathon {
	
	public static void main(String args[]) throws IOException{
			BufferedReader file = new BufferedReader(new FileReader("marathon.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
			
			int numOfPoints = Integer.parseInt(file.readLine());
			
			int[] firstPoint = new int[2];
			int[] secondPoint = new int[2];
			int[] thirdPoint = new int[2];
			int currdistanceSaved = 0;
			int maxDistanceSaved = 0;
			
			String line = file.readLine();
			StringTokenizer token = new StringTokenizer(line);
			firstPoint[0] = Integer.parseInt(token.nextToken());
			firstPoint[1] = Integer.parseInt(token.nextToken()); 
		
			String line2 = file.readLine();
			StringTokenizer token2 = new StringTokenizer(line2);
			secondPoint[0] = Integer.parseInt(token2.nextToken());
			secondPoint[1] = Integer.parseInt(token2.nextToken()); 
			
			int totalDistance = Math.abs(secondPoint[0] - firstPoint[0]) + Math.abs(secondPoint[1] - firstPoint[1]);
					
			//numOfPoint-2 because you are not counting the first and last point
			for(int i = 0; i < numOfPoints-2; i++) {
				//getpointC
				String line3 = file.readLine();
				//System.out.println(line3);
				StringTokenizer token3 = new StringTokenizer(line3);
				thirdPoint[0] = Integer.parseInt(token3.nextToken());
				thirdPoint[1] = Integer.parseInt(token3.nextToken());
				//(a>b + b>c - a>c) = regular distance - shortcut distance = distance saved
				currdistanceSaved = ((Math.abs(secondPoint[0] - firstPoint[0]) + Math.abs(secondPoint[1] - firstPoint[1])) + (Math.abs(thirdPoint[0] - secondPoint[0]) + Math.abs(thirdPoint[1] - secondPoint[1])) - (Math.abs(thirdPoint[0] - firstPoint[0]) + Math.abs(thirdPoint[1] - firstPoint[1])));
			//	System.out.println(currdistanceSaved);
				totalDistance += (Math.abs(thirdPoint[0] - secondPoint[0]) + Math.abs(thirdPoint[1] - secondPoint[1]));
				//System.out.println("iteration " + i + " total distance: " + totalDistance);
				if(currdistanceSaved > maxDistanceSaved) {
					maxDistanceSaved = currdistanceSaved;
				}
				
				//set new points
				firstPoint[0] = secondPoint[0];
				firstPoint[1] = secondPoint[1];
				secondPoint[0] = thirdPoint[0];
				secondPoint[1] = thirdPoint[1];
			}
			out.print(totalDistance - maxDistanceSaved);
			out.close();
		
	}
}
