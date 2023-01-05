package application;

import models.entities.Account;
import models.exceptions.CustomExceptions;

import javax.swing.undo.CannotUndoException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            double withdrawAmount = sc.nextDouble();
            account.withdraw(withdrawAmount);

            System.out.println("New balance: " + account.toString());
        }
        catch (CustomExceptions e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}