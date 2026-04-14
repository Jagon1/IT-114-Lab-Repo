import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeProcessor {

    public static void main(String[] args) {
        
        // Input and Output file names
        String inputFileName = "student_data.txt";
        String outputFileName = "grade_report.txt";

        // TODO 1: Wrap your code in a try-catch block.
        // The catch block should handle 'FileNotFoundException'.
        try { 

            // TODO 2: Create a File object and a Scanner to read the input file.
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);

            // TODO 3: Create a PrintWriter object to write to the output file.
            PrintWriter writer = new PrintWriter(outputFileName);
            System.out.println("Processing file...");
            
            // Write the header to the output file separated by tab characters (\t);
            // Print a dashed line ("--------------------");
            writer.println("Name\tAverage\tResult");
            writer.println("--------------------");

            // TODO 4: Create a while loop to process the file line by line.
            //   - Read the name (String)
            //   - Read the three scores (int or double)
            //   - Calculate the average
            //   - Determine "Pass" or "Fail" (Pass is >= 70.0)
            //   - Write the formatted line to the output file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    double score1 = Double.parseDouble(parts[1].trim());
                    double score2 = Double.parseDouble(parts[2].trim());
                    double score3 = Double.parseDouble(parts[3].trim());
                    
                    double average = (score1 + score2 + score3) / 3.0;
                    String result = average >= 70.0 ? "Pass" : "Fail";
                    
                    writer.printf("%s\t%.2f\t%s%n", 
                                  name, average, result);
                }
            }

            // TODO 5: Close both the Scanner and the PrintWriter.
            scanner.close();
            writer.close();
            System.out.println("Done! Check " + outputFileName + " for results.");

        // TODO 6: catch block:
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file " + inputFileName + " not found.");
        }
    }
}