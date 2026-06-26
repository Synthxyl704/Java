import java.util.Scanner;

public class JavaExercises {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter a number to check even/odd: ");
        int n = s.nextInt();
        System.out.println(n + " is " + (n % 2 == 0 ? "even" : "odd"));
        
        System.out.print("\nEnter array size: ");
        int size = s.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum of array elements: " + sum);
        
        System.out.print("\nEnter a string to reverse: ");
        String str = s.next();
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string: " + reversed);
        
        System.out.print("\nEnter first number to swap: ");
        int x = s.nextInt();
        System.out.print("Enter second number to swap: ");
        int y = s.nextInt();
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("After swap: x = " + x + ", y = " + y);
        
        System.out.print("\nEnter a number for multiplication table: ");
        int num = s.nextInt();
        System.out.println("Multiplication table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        
        s.close();
    }
}
