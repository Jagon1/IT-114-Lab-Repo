public class CheckingAccount extends BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON THEM.
    private final double OVERDRAFT_FEE = 35.00;

    public CheckingAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'
        super(accountHolder, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        // TODO: Implement Checking withdrawal logic
        double presentBalance= getBalance();
        if(amount>presentBalance){
            setBalance(presentBalance-amount-OVERDRAFT_FEE);
        } else {
            setBalance(presentBalance-amount);
        }
    }
}