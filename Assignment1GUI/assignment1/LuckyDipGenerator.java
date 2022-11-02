package assignment1;

import java.sql.SQLOutput;

import static java.lang.Math.random;

/**
 * This class LuckyDipGenerator is to generate a random number.
 * Generate a random number in a setted limit range (start, end).
 *
 * @author  Zhang
 * @version 1.8.0   28 March 2020
 */
public class LuckyDipGenerator
{
    /**
     * Generate a random
     * Generate a random number in a setted limit range (start, end).
     *
     * @param start an int to set the start of range
     * @param end   an int to set the end of the range
     * @return int number
     */
    public static int generateNumber(int start, int end)
    {
        return start + (int) (random() * (end - start + 1));
    }


    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(generateNumber(1,5));
        }
    }
}


