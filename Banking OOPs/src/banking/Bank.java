package banking;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    public Account findAccount(String accountNumber) {

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("Account Not Found!");
        return null;
    }

    public void transferFund(String fromAccountNumber, String toAccountNumber, double amount) {

        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
        }
        else {
            System.out.println("Account numbers not found!");
        }
    }
}
