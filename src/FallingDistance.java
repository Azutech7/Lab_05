import java.util.Scanner;

/**
 * Program Description
 * 1) Prompts users for how many seconds to compute of an object falling
 * 2) Calculates the total distance it has fallen at each second, up to the user's limit
 * 
 * @author Mason Heuberger, mheuberger@student.sdccd.edu
 * @version v1.0
 * @since 2026-10-04
 */

public class FallingDistance {

    public static final double ACCELERATION = 9.8;
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance;
        int numOfSecs;

        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = scanner.nextInt();

        System.out.println("\nTime(secs)\tDistance(m)\n==========\t===========");

        for (int t = 1; t <= numOfSecs; t++) {
        	distance = getDistance(t);
        	System.out.printf("%d\t%.1f%n", t, distance);
        }
    }
    
    /**
     * Calculates the distance an object would have fallen after given time
     *
     * @param inTime time falling in seconds
     * @return distance fallen in meters
     */
	public static double getDistance(int inTime) {
		return 0.5 * ACCELERATION * Math.pow(inTime, 2);
	}
}
