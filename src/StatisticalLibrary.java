import java.util.ArrayList;
import java.util.Collections;

/**
 * Applied rules from Google Java Style Guide:
 * 3.4.1 Exactly one top-level class declaration
 * 4.1.1 Use of optional braces
 * 4.1.2 Nonempty blocks: K & R style
 * 4.2 Block indentation: +2 spaces
 * 4.3 One statement per line
 * 4.6.1 Vertical Whitespace
 * 4.6.2 Horizontal whitespace
 */

/**
 * Library of Statistical Calculations.
 *
 * This class provides methods for calculating statistical values such as mean, median, minimum, and maximum.
 *
 * @author Alby Babu
 * @version 1.0
 */
public class StatisticalLibrary {

    /**
     * Calculates the mean of the given list, optionally excluding values below a certain cutoff.
     *
     * @param values the list of values
     * @param cutoff the minimum value to include (optional)
     * @param excludeBelowCutoff whether to exclude values below the cutoff
     * @return the mean of the values
     */
    public static double calculateMean(ArrayList<Double> values, double cutoff, boolean excludeBelowCutoff) {
        double sum = 0;
        int count = 0;

        for (double value : values) { //Iterate over the list of values.
            if (excludeBelowCutoff) {
                if (value >= cutoff) {
                    sum += value;
                    count++;
                }
            } else {
                sum += value;
                count++;
            }
        }
        return sum / count;
    }

    /**
     * Calculates the median of the given list.
     *
     * @param values the list of values
     * @return the median of the values
     */
    public static double calculateMedian(ArrayList<Double> values) {

        Collections.sort(values);//Sort the list of values in ascending order.
        int size = values.size(); //Get the size of the list.
        if (size % 2 == 1) { //Check if the list has an odd number of elements.

            return values.get(size / 2);
        } else {

            int mid1 = size / 2 - 1;
            int mid2 = size / 2;

            return (values.get(mid1) + values.get(mid2)) / 2.0;
        }
    }

    /**
     * Finds the minimum value in the given list.
     *
     * @param values the list of values
     * @return the minimum value
     */
    public static double findMin(ArrayList<Double> values) {
        double min = values.get(0); //Initialize the minimum value to the first element in the list.

        for (double value : values) {

            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    /**
     * Finds the maximum value in the given list.
     *
     * @param values the list of values
     * @return the maximum value
     */
    public static double findMax(ArrayList<Double> values) {

        double max = values.get(0); //Initialize the maximum value to the first element in the list.

        for (double value : values) {

            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    /**
     * Main method for testing the statistical calculations.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Double> data = new ArrayList<>(); //Create a list of values

        Collections.addAll(data, 25.5, 29.4, 36.7, 43.1, 57.9, 88.3, 99.9, 100.0);

        System.out.println("Mean: " + calculateMean(data, 0, true)); //Calculate and print the mean, median, minimum, and maximum values.
        System.out.println("Median: " + calculateMedian(data));
        System.out.println("Min: " + findMin(data));
        System.out.println("Max: " + findMax(data));
    }
}