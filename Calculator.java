import java.util.Scanner;

public class Calculator {
    public static double calculate(double first, char operator, double second) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if (second == 0) {
                    throw new ArithmeticException("cannot divide by zero");
                }
                return first / second;
            default:
                throw new IllegalArgumentException("unsupported operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Basic Calculator");
        System.out.println("Enter q at any prompt to quit.");

        while (true) {
            System.out.print("First number: ");
            String firstInput = scanner.nextLine().trim();
            if (firstInput.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Operation (+, -, *, /): ");
            String operatorInput = scanner.nextLine().trim();
            if (operatorInput.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Second number: ");
            String secondInput = scanner.nextLine().trim();
            if (secondInput.equalsIgnoreCase("q")) {
                break;
            }

            try {
                if (operatorInput.length() != 1) {
                    throw new IllegalArgumentException("invalid operator");
                }
                double result = calculate(
                        Double.parseDouble(firstInput),
                        operatorInput.charAt(0),
                        Double.parseDouble(secondInput));
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException error) {
                System.out.println("Please enter valid numbers and one of +, -, *, or /.");
            } catch (ArithmeticException error) {
                System.out.println("Error: " + error.getMessage() + ".");
            }
        }

        scanner.close();
    }
}