import java.util.Scanner;

/**
 * Program Description
 * 1) Asks the user for a number to figure out if it is prime or not
 * 2) Tests the number and prints the result
 * 3) Asks the user if they would like to preform another test
 * 
 * @author Mason Heuberger, mheuberger@student.sdccd.edu
 * @version v1.0
 * @since 2026-10-04
 */
public class Prime {
    public static void main (String[] args) {
    
    	Scanner scanner = new Scanner(System.in);
        boolean isPrime;
        int number;
        String playAgain;

        do {
        	System.out.print("Enter a whole number>2 (ie 19) to test if prime: ");
        	number = scanner.nextInt();

        	isPrime = testForPrime(number);
        	if (isPrime) {
        		System.out.println(number+" is prime");
        	} else {
        		System.out.println(number+" is not prime");
        	}

        	System.out.print("Enter yes to test another number, no to quit. ");
        	playAgain = scanner.next();
        } while (playAgain.toLowerCase().equals("yes"));

    }

    /**
     * Tests if a number is prime
     *
     * @param inNumber whole number to be tested
     * @return true if prime, false if not
     */
	public static boolean testForPrime(int inNumber) {
		int inNumberSqRt = (int)Math.sqrt(inNumber);
		boolean isPrimeMeth = true;
	
        for(int i=2;isPrimeMeth&&i<=inNumberSqRt;i++){
        	if (inNumber % i == 0) {
        		isPrimeMeth = false;
        	}
        }
        
        return isPrimeMeth;
    }
}
