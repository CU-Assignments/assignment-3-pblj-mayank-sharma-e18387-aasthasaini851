// SquareRootCalculator.java
import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();

            if (num < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate the square root of a negative number.");
            }

            System.out.println("Square root: " + Math.sqrt(num));
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}
