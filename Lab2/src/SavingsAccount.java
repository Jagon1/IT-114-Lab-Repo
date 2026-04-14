public class SavingsAccount extends BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON THEM.
    public SavingsAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'
        super(accountHolder, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        // TODO: Implement Savings withdrawal logic
        double presentBalance= getBalance();
        if (amount <= presentBalance) {
            setBalance(presentBalance-amount);
        }
    }
}