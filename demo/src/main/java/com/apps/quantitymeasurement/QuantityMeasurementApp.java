package com.apps.quantitymeasurement;

import java.util.Scanner;

// import com.apps.quantitymeasurement.LengthUnit;
// import com.apps.quantitymeasurement.Length;

/**
 * Hello world!
 *
 */
public class QuantityMeasurementApp {
    // Inner class to represent Feet measurement

    // Helper method to read Length from user input

    private static Length readLength(Scanner scanner) {
        System.out.print("Enter length value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String unitInput = scanner.next().toUpperCase();
        LengthUnit unit;
        try {
            unit = LengthUnit.valueOf(unitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        return new Length(value, unit);

    }

    // Length equality demonstration
    public static void demonstrateLengthEquality(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);
        System.out.println("Input: Quantity(" + length1.getValue() + "," + length1.getUnit().name().toLowerCase() +
                ").equals(Quantity(" + length2.getValue() + "," + length2.getUnit().name().toLowerCase() + "))");
        System.out.println("Output: " + length1.equals(length2));
    }


    //Length Comparison demonstration
    public static void demonstrateLengthComparison(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);

        System.out.println("Input: Quantity(" + length1.getValue() + "," + length1.getUnit().name().toLowerCase() +
                ").equals(Quantity(" + length2.getValue() + "," + length2.getUnit().name().toLowerCase() + "))");
        System.out.println("Output: " + length1.equals(length2));
    }

    //Demonstrate length conversion form base unit to target unit
    public static Length demonstrateLengthConversion(Scanner scanner) {
        System.out.print("Enter length value: ");
        double value = scanner.nextDouble();

        LengthUnit fromUnit = LengthUnit.INCHES; // Base unit for conversion

        System.out.print("Enter target length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String toUnitInput = scanner.next().toUpperCase();
        LengthUnit toUnit;
        try {
            toUnit = LengthUnit.valueOf(toUnitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        Length tempLength = new Length(value, fromUnit);
        return tempLength.convertToTargetUnit(value,toUnit);
    }




    //demonstration Length Conversion to target unit
    public static Length demonstrateLengthConversionToTargetUnit(Scanner scanner) {
        System.out.print("Enter length value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String fromUnitInput = scanner.next().toUpperCase();
        LengthUnit fromUnit;
        try {
            fromUnit = LengthUnit.valueOf(fromUnitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        System.out.print("Enter target length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String toUnitInput = scanner.next().toUpperCase();
        LengthUnit toUnit;
        try {
            toUnit = LengthUnit.valueOf(toUnitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        Length tempLength = new Length(value, fromUnit);
        return tempLength.convertTo(toUnit);
    }

    // Demonstrate addition of lengths with result in first length's unit
    public static Length demonstrateLengthAddition(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);

        System.out.println("Input: Quantity 1: " + length1.getValue() + " " + length1.getUnit().name().toLowerCase() +
                ", Quantity 2: " + length2.getValue() + " " + length2.getUnit().name().toLowerCase());
        return length1.add(length2);
    }

    // Demonstrate addition of lengths with target unit
    public static Length demonstrateLengthAdditionWithTargetUnit(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);

        System.out.print("Enter target length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String unitInput = scanner.next().toUpperCase();
        LengthUnit targetUnit;
        try {
            targetUnit = LengthUnit.valueOf(unitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        System.out.println("Input: Quantity 1: " + length1.getValue() + " " + length1.getUnit().name().toLowerCase() +
                ", Quantity 2: " + length2.getValue() + " " + length2.getUnit().name().toLowerCase());
        return length1.add(length2, targetUnit);
    }

    // Display menu
    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("   QUANTITY MEASUREMENT APPLICATION");
        System.out.println("========================================");
        System.out.println("1. Check Length Equality");
        System.out.println("2. Compare Lengths");
        System.out.println("3. Convert Length from Base Unit to Target Unit");
        System.out.println("4. Convert Length to Target Unit");
        System.out.println("5. Add Two Lengths (Result in First Length's Unit)");
        System.out.println("6. Add Two Lengths (Result in Custom Unit)");
        System.out.println("7. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice (1-7): ");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                try {
                    displayMenu();
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            // Check Length Equality
                            System.out.println("\n--- Check Length Equality ---");
                            demonstrateLengthComparison(scanner);
                            break;

                        case 2:
                            // Compare Lengths
                            System.out.println("\n--- Compare Lengths ---");
                            demonstrateLengthComparison(scanner);
                            break;

                        case 3:
                            // Convert Length from Base Unit to Target Unit
                            System.out.println("\n--- Convert from Base Unit (Inches) ---");
                            Length convertedFromBase = demonstrateLengthConversion(scanner);
                            System.out.println("Converted Length: " + convertedFromBase.getValue() + " "
                                    + convertedFromBase.getUnit().name().toLowerCase());
                            break;

                        case 4:
                            // Convert Length to Target Unit
                            System.out.println("\n--- Convert Length to Target Unit ---");
                            Length convertedLength = demonstrateLengthConversionToTargetUnit(scanner);
                            System.out.println("Converted Length: " + convertedLength.getValue() + " "
                                    + convertedLength.getUnit().name().toLowerCase());
                            break;

                        case 5:
                            // Add Two Lengths (Result in First Length's Unit)
                            System.out.println("\n--- Add Two Lengths ---");
                            Length sumLength = demonstrateLengthAddition(scanner);
                            System.out.println("Sum of lengths: " + sumLength.getValue() + " "
                                    + sumLength.getUnit().name().toLowerCase());
                            break;

                        case 6:
                            // Add Two Lengths with Target Unit
                            System.out.println("\n--- Add Two Lengths (Custom Unit) ---");
                            Length sumLengthWithTargetUnit = demonstrateLengthAdditionWithTargetUnit(scanner);
                            System.out.println("Sum of lengths: " + sumLengthWithTargetUnit.getValue() + " "
                                    + sumLengthWithTargetUnit.getUnit().name().toLowerCase());
                            break;

                        case 7:
                            // Exit
                            System.out.println("\nThank you for using Quantity Measurement Application!");
                            running = false;
                            break;

                        default:
                            System.out.println("\nInvalid choice! Please enter a number between 1 and 7.");
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("\nError: " + e.getMessage());
                    scanner.nextLine(); // Clear invalid input
                } catch (Exception e) {
                    System.out.println("\nInvalid input! Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
        }
    }
}