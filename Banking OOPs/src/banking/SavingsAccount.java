package banking;

public class SavingsAccount extends Account {

    private final double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }

}
