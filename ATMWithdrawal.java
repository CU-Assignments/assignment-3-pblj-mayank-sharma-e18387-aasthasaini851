// ATMWithdrawal.java
import java.util.Scanner;

class ATM {
    private double balance;
    private final int correctPIN = 1234;

    public ATM(double balance) {
        this.balance = balance;
    }

    public void withdraw(int pin, double amount) {
        try {
            if (pin != correctPIN) {
                throw new SecurityException("Error: Invalid PIN.");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Error: Insufficient balance.");
            }
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Current Balance: " + balance);
        }
    }
}

public class ATMWithdrawal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(3000);

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        System.out.print("Withdraw Amount: ");
        double amount = scanner.nextDouble();

        atm.withdraw(pin, amount);
        scanner.close();
    }
}
