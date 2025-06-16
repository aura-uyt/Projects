package banking;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        SavingsAccount savingsAccount = new SavingsAccount("SA123", "Ajya", 7000, 6.5);
        CurrentAccount currentAccount = new CurrentAccount("CA321", "Saacho", 15000, 4000);

        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        savingsAccount.deposit(2000);
        currentAccount.withdraw(7000);

        savingsAccount.addInterest();

        bank.transferFund("CA321", "SA123",7000);

        savingsAccount.checkBalance();
        currentAccount.checkBalance();

        currentAccount.withdraw(3000);
        currentAccount.checkBalance();

        currentAccount.withdraw(40000);
        currentAccount.checkBalance();
        System.out.println();

        bank.transferFund("A321","SA123", 40000);  // error: transfers any amount!
        currentAccount.checkBalance();
        savingsAccount.checkBalance();
    }
}
/*
Access Modifiers
    Modifier	  Same Class    Same Package    Subclass (diff pkg)	   Other Packages
    private	          ✅            ❌                ❌                   ❌
    (no modifier)	  ✅            ✅                ❌                   ❌
    protected	      ✅            ✅                ✅                   ❌
    public	          ✅            ✅                ✅                   ✅

TL;DR
    private = only within the same class
    protected = same package + all subclasses (even outside the package)
    default (no modifier) = same package only
    public = everyone

*/