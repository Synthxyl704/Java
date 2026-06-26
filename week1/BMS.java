import java.util.Scanner;

public class BankManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double balance = 0;
        int choice;
        do {
            System.out.println("\n- Bank Management (BM!) -");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = s.nextDouble();
                    if (dep > 0) {
                        balance += dep;
                        System.out.println("Deposited: " + dep);
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double with = s.nextDouble();
                    if (with > 0 && with <= balance) {
                        balance -= with;
                        System.out.println("Withdrawn: " + with);
                    } else {
                        System.out.println("Invalid amount or insufficient balance!");
                    }
                    break;
                case 3:
                    System.out.println("Current Balance: " + balance);
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        
s.close();
    }
}
