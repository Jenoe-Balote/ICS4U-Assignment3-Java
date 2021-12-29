/*
 * This program prints an hourglass of asterisks through recursion.
 *
 * @author  Jenoe Balote
 * @version 1.0
 * @since   2021-12-28
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class runs the Asterisk Hourglass program.
 * */
final class AsteriskHourglass {

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private AsteriskHourglass() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Generates the hourglass through recursion.
     *
     * @param size the size of the hourglass, inclusive
     * @param offset the offset
     * */
    private static void hourglass(final int size, final int offset) {
        // prints top line
        printHourglass(size, offset);
        if (size > 1) {
            // recursive call
            hourglass(size - 1, offset + 1);
            // prints bottom line
            printHourglass(size, offset);
        // Middle of hourglass
        } else if (size == 1) {
            printHourglass(size, offset);
        }
    }

    /**
     * Prints out the asterisk hourglass.
     *
     * @param size the size of the hourglass, inclusive
     * @param offset the offset
     * */
    private static void printHourglass(final int size, final int offset) {
        System.out.println(" ".repeat(offset) + "* ".repeat(size));
    }

    /**
     * Main function of the Asterisk Hourglass Program.
     *
     * @param args No args will be used.
     * */
    public static void main(final String[] args) {
        // User Input
        System.out.println("Welcome to the Asterisk Hourglass Program!");
        try {
            System.out.print("Please enter the size of the hourglass: ");
            final String sizeString = new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine();

            final int size = Integer.parseInt(sizeString);

            // Makes sure the user inputted the appropriate amount.
            if (size >= 1) {
                System.out.println("");
                hourglass(size, 0);
            } else {
                System.out.println(
                    "Please enter an integer greater than one.");
            }
        // Makes sure the user inputs an integer.
        } catch (IOException | NumberFormatException exception) {
            System.out.println("Please enter an integer.");
        } finally {
            System.out.println("\nDone.");
        }
    }
}
