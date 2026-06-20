import java.util.Scanner;

class BankAccount {

    String name;
    int pin;
    double balance;

    String[] transactions = new String[5];
    int transactionCount = 0;

    public BankAccount(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public void addTransaction(String transaction) {

        if (transactionCount < 5) {
            transactions[transactionCount] = transaction;
            transactionCount++;
        } else {

            for (int i = 0; i < 4; i++) {
                transactions[i] = transactions[i + 1];
            }

            transactions[4] = transaction;
        }
    }

    public void checkBalance() {
        System.out.println("\nCurrent Balance : ₹" + balance);
    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            addTransaction("Deposit : ₹" + amount);

            System.out.println("₹" + amount +
                    " Deposited Successfully");

            System.out.println("Updated Balance : ₹" + balance);

        } else {

            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid Amount!");

        } else if (amount > balance) {

            System.out.println("Insufficient Balance!");

        } else {

            balance -= amount;

            addTransaction("Withdraw : ₹" + amount);

            System.out.println("₹" + amount +
                    " Withdrawn Successfully");

            System.out.println("Updated Balance : ₹" + balance);
        }
    }

    public void miniStatement() {

        System.out.println("\n----- MINI STATEMENT -----");

        if (transactionCount == 0) {

            System.out.println("No Transactions Found.");

        } else {

            for (int i = 0; i < transactionCount; i++) {
                System.out.println(transactions[i]);
            }
        }

        System.out.println("Current Balance : ₹" + balance);
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      ATM INTERFACE SYSTEM");
        System.out.println("=================================");

        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();

        System.out.print("Create 4 Digit PIN : ");
        int pin = sc.nextInt();

        System.out.print("Enter Initial Balance : ");
        double balance = sc.nextDouble();

        BankAccount account =
                new BankAccount(name, pin, balance);

        System.out.println("\nAccount Created Successfully!");

        int attempts = 3;
        boolean loginSuccess = false;

        while (attempts > 0) {

            System.out.print("\nEnter PIN to Login : ");
            int enteredPin = sc.nextInt();

            if (enteredPin == account.pin) {

                loginSuccess = true;

                System.out.println(
                        "\nLogin Successful!");

                break;

            } else {

                attempts--;

                System.out.println(
                        "Wrong PIN! Remaining Attempts : "
                                + attempts);
            }
        }

        if (!loginSuccess) {

            System.out.println(
                    "\nToo Many Failed Attempts.");

            System.out.println(
                    "Account Locked!");

            sc.close();
            return;
        }

        int choice;

        do {

            System.out.println(
                    "\n========== ATM MENU ==========");

            System.out.println(
                    "1. Check Balance");

            System.out.println(
                    "2. Deposit Money");

            System.out.println(
                    "3. Withdraw Money");

            System.out.println(
                    "4. Mini Statement");

            System.out.println(
                    "5. Exit");

            System.out.print(
                    "Enter Your Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    account.checkBalance();
                    break;

                case 2:

                    System.out.print(
                            "Enter Amount : ");

                    double depositAmount =
                            sc.nextDouble();

                    account.deposit(depositAmount);

                    break;

                case 3:

                    System.out.print(
                            "Enter Amount : ");

                    double withdrawAmount =
                            sc.nextDouble();

                    account.withdraw(withdrawAmount);

                    break;

                case 4:

                    account.miniStatement();

                    break;

                case 5:

                    System.out.println(
                            "\nThank You " + account.name);

                    System.out.println(
                            "Visit Again!");

                    break;

                default:

                    System.out.println(
                            "Invalid Choice!");
            }

        } while (choice != 5);
        //close resources
        sc.close();
    }
}