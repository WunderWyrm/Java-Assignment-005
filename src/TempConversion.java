/**
 *
 * @author Trevor Hartman
 * @author Samuel Theiss
 *
 * @since Version 1.0
 *
 */

import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertK2F(double kelvin) {
        return convertC2F(convertK2C(kelvin));
    }

    public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit.toUpperCase()));
        return Double.parseDouble(input.nextLine());
    }

    public static String getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert from a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert from a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert from a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.nextLine();
    }

    public static String getUnitChoice2() { // An addition to make it easier to see what the second option is for.
        System.out.printf("%-4s : %40s%n", "C).", "To convert to a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert to a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert to a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.nextLine();
    }

    public static void main(String[] args) {
        while(true) {

            String convertFrom = getUnitChoice().toLowerCase(); // Looking back on this, it would've been easier to use .toUpperCase() here instead of on all the display areas.

            if (convertFrom.equals("q")) { break; }

            String convertTo = getUnitChoice2().toLowerCase();

            if (convertTo.equals("q")) { break; }
            if (convertFrom.equals(convertTo)) {
                System.out.println("\nPlease choose two different units to convert.\n");
                continue;
            }

            double initialTemp = getTemp(convertFrom);


            switch (convertFrom) {
                case "c":
                    switch (convertTo) {
                        case "f":
                            System.out.printf("\nResult %f°%s is %f°%s\n\n", initialTemp, convertFrom.toUpperCase(), convertC2F(initialTemp), convertTo.toUpperCase());
                            break;
                        case "k":
                            System.out.printf("\nResult %f°%s is %f°%s\n\n", initialTemp, convertFrom.toUpperCase(), convertC2K(initialTemp), convertTo.toUpperCase());
                            break;
                    }
                    break;

                case "f":
                    switch (convertTo) {
                        case "c":
                            System.out.printf("\nResult %f°%s is %f°%s\n\n", initialTemp, convertFrom.toUpperCase(), convertF2C(initialTemp), convertTo.toUpperCase());
                            break;
                        case "k":
                            System.out.printf("\nResult %f°%s is %f°%s\n\n", initialTemp, convertFrom.toUpperCase(), convertF2K(initialTemp), convertTo.toUpperCase());
                            break;
                    }
                    break;

                case "k":
                    switch (convertTo) {
                        case "c":
                            System.out.printf("\nResult %f°%s is %f°%s\n\n", initialTemp, convertFrom, convertK2C(initialTemp), convertTo);
                            break;
                        case "f":
                            System.out.printf("\nResult %f°%s is %f°%s\n\n", initialTemp, convertFrom, convertK2F(initialTemp), convertTo);
                            break;
                    }
                    break;
            }
        }
    }
}