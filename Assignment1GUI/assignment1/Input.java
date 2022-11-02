package assignment1;

import java.util.Scanner;

/**
 * This class Input get input content via Scanner class.
 * To get input String, no need to check.
 * To get input int, need to check if it is int. if not, ask input again until the input is int.
 *
 * @author  Zhang
 * @version 1.8.0   28 March 2020
 */
public class Input
{
    /**
     * Input int via Scanner class
     * check if the input is int (scan.hasNextInt())
     * still ask input until the input is int (while loop)
     *
     * @return int inputNumber
     */
    public static int inputInt()
    {
        int inputNumber = 0;
        Scanner scan = new Scanner(System.in);
        //System.out.print("Please enter a number: "); // Kiosk already include
        while (!scan.hasNextInt())
        {
            scan.next();
            System.out.print("INVALID ENTRY! Please enter a integer number: ");
        }
        inputNumber = scan.nextInt();
        // scan.close(); // cannot close, in loop will error!!!
        return inputNumber;
    }

    /**
     * Input String via Scanner
     * no check, no loop
     *
     * @return String inputString
     */
    public static String inputString()
    {
        String inputString = "";
        Scanner scan = new Scanner(System.in);
        // System.out.print("Please enter a string："); // Kiosk already include
        inputString = scan.next();
        // scan.close(); // cannot close, in loop will error!!!
        return inputString;
    }

    /**
     * =========================== Test ===========================
     */
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            inputInt();
            inputString();
        }
    }
}
