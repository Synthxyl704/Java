import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("[Basic Calculator]\n1. Addition (+)\n2. Subtraction (-)\n3. Multiplication (*)\n4. Division (/)\n");
        
        System.out.print("Enter first number: ");
        double a = s.nextDouble();
        System.out.print("Enter operation (+, -, *, /): ");

        char op = s.next().charAt(0);
        System.out.print("Enter second number: ");

        double b = s.nextDouble();
        double r = 0;
        boolean v = true;
        switch (op) {
            case '+': r = a + b; break;
            case '-': r = a - b; break;
            case '*': r = a * b; break;
            case '/': if (b != 0) r = a / b; else { System.out.println("Error: div by 0 not allowed"); v = false; } break;
            default: System.out.println("Error: invalid operatorm pls use (+, -, *, or /)"); v = false;
        }
        if (v) System.out.println("\nResult: " + a + " " + op + " " + b + " = " + r);
        s.close();
    }
}
