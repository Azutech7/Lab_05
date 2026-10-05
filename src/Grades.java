import java.util.Scanner;
import java.io.*;

/**
 * Program Description
 * 1) Asks for a valid input file, and will keep asking
 * 2) Asks for a target output file
 * 3) Reports the set number, number of each letter grade, highest score, lowest score, and the average score
 * 
 * @author Mason Heuberger, mheuberger@student.sdccd.edu
 * @version v1.0
 * @since 2026-10-04
 */
public class Grades {
    public static void main (String[] args) throws IOException {
    	String inFile, outFile;
    	inFile = getInFile();
    	outFile = getOutFile();
    	processFile(inFile, outFile);
    }

    /**
     * Uses Scanner to get and return input file name
     * @return name of file from Scanner
     */
    public static String getInFile() throws IOException {
    	Scanner keyboard = new Scanner(System.in);
    	String inputFileName;
    	File inputFile;
    	
    	do {
	    	System.out.print("Enter the name of the input file (ie input.txt): ");
	    	inputFileName = keyboard.nextLine();
	    	inputFile = new File(inputFileName);
	    	
	    	if (!inputFile.exists())
	    		System.out.print("File not found. ");
		} while (!inputFile.exists());
    	
		return inputFileName;
    }

    
    /**
     * Uses Scanner to get and return output file name
     * @return name of the file from Scanner
     */
    public static String getOutFile() {
    	Scanner keyboard = new Scanner(System.in);
    	String outputFileName;
    	
    	System.out.print("Enter the name of the output file (ie output.txt): ");
    	outputFileName = keyboard.nextLine();
    	
		return outputFileName;
    }
    
        
    /**
     * Reads through a input grades file from L-to-R, T-to-B, stopping at -1 each line
     * Reports the set number, number of each letter grade, highest score, lowest score, and the average score
     * 
     * @param inInputFileName name of existing file for input data to be read from
     * @param inOutputFileName name of possibly existing file for output data to go
     */    
    public static void processFile(String inInputFileName, String inOutputFileName) throws IOException {
    	int set, noA, noB, noC, noD, noF, high, low, total, count, current; // no<letter> = number of <letter>
    	double avg;
    	
    	File inputFile = new File(inInputFileName);
    	File outputFile = new File(inOutputFileName);

    	Scanner inputScanner = new Scanner(inputFile);
    	PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFile));

    	// Initial values;
		set = 1;
		noA = noB = noC = noD = noF = high = total = count = 0;
		low = Integer.MAX_VALUE; // To account for the possibility of extra credit (>100%) scores
		
    	while (inputScanner.hasNext()) {
		
			current = inputScanner.nextInt();
    		
    		if (current == -1) {

    			avg = (double)total / count;
    			// Log data
				outputWriter.println("Set "+set+" of grades calculated");
				if (count != 0) {
					outputWriter.println("Number of As: "+noA);
					outputWriter.println("Number of Bs: "+noB);
					outputWriter.println("Number of Cs: "+noC);
					outputWriter.println("Number of Ds: "+noD);
					outputWriter.println("Number of Fs: "+noF);
					outputWriter.println("The high score was: "+high);
					outputWriter.println("The low score was: "+low);
					outputWriter.printf("The avg score is: %.1f%n", avg);
				} else {
					outputWriter.println("No grades to average");
				}
				outputWriter.println();
				
    			// Reset variables
    			set++;
    			noA = noB = noC = noD = noF = high = total = count = 0;
    			low = Integer.MAX_VALUE; // To account for the possibility of extra credit (>100%) scores
    			
    		} else {

				if (current < 60)
					noF++;
				else if (current < 70)
					noD++;
				else if (current < 80)
    				noC++;
    			else if (current < 90)
    				noB++;
    			else
    				noA++;

				if (current > high)
					high = current;
				if (current < low)
					low = current;
				
    			total += current;
    			count++;
    			
    		}
    	}

    	inputScanner.close();
    	outputWriter.close();

    	System.out.println("Grade processing completed");
    	System.out.println("You can retrieve the output file at, "+inOutputFileName);
    }


}
