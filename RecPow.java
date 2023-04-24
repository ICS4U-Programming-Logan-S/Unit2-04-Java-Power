import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
* This program gets input from a file,
* and uses a recursive function to
* calculate the power for the two numbers
* in the file.
*
* @author Logan S
* @version 1.0
* @since 2023-04-24
*/

public final class RecPow {

    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */

    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */

    public static void main(String[] args) {
        // Clear output file
        final File outputFile = new File("output.txt");
        FileWriter outputWriter = new FileWriter(outputFile);
        outputWriter.write("");
        outputWriter.close();

        // Read input from file
        final File inputFile = new File("input.txt");
        final Scanner scnr = new Scanner(inputFile);

        // Process each line of input
        while (scnr.hasNextLine()) {
            final String line = scnr.nextLine();
            final String[] parts = line.split(" ");
            final int base = Integer.parseInt(parts[0]);
            final int exponent = Integer.parseInt(parts[1]);

            // Calculate power
            final int result = power(base, exponent);

            // Write output to file
            outputWriter = new FileWriter(outputFile, true);
            outputWriter.write(base + "^" + exponent + " = " + result + "\n");
            outputWriter.close();
        }

        scnr.close();
    }

    /**
    * This is the main method.
    *
    * @param base The base.
    * @param exponent the exponent
    * @return the reversed string.
    */

    public static int power(int base, int exponent) {
        // Base case: if exponent is equal to 0
        if (exponent == 0) {
            return 1;
        }
        // Else: if exponent is not equal to 0
        return base * power(base, exponent - 1);
    }
}
