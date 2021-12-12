/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Malcolm Tompkins
* @version 1.0
* @since   2021-12-12
*/

import java.util.Scanner;

/**
* TowerOfHanoi class.
*/
final class TowerOfHanoi {

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private TowerOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Function for recusive algorithm.
    *
    * @param nOfDisks Number of disks input by user
    * @param startPeg The peg where the disk being moved lies
    * @param endPeg The peg of which the disk is being moved to
    */
    static void hanoi(final int nOfDisks, final int startPeg,
                             final int endPeg) {
        // This function calculates where the disks should be placed in
        final int pegNumber = 6;
        final String toPeg = " to peg ";
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + toPeg
                               + endPeg);
        } else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks + " from peg "
                               + startPeg + toPeg
                               + endPeg);
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
    * Main() function for input and output.
    *
    * @param args Unused parameter
    */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // Input
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            final int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // Process
                hanoi(nOfDisks, startPeg, endPeg);
                // Output
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (java.util.InputMismatchException error) {
            System.err.print("\nThis is not an integer");
        }

        System.out.println("\nDone.");
    }
}
