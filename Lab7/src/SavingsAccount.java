public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'
        super(accountHolder, initialDeposit);
    }

    @Override
    public String withdraw(double amount) {
        // TODO: Implement Savings withdrawal logic and error handling for incorrect input
        if (amount > 0) {
            if (this.getBalance() >= amount) {
                this.setBalance(this.getBalance() - amount);
                return "Withdrawal successful. New balance: $" + this.getBalance();
            } else {
                return "Insufficient funds.";
            }
        } else {
            return "Invalid withdrawal amount.";
        }
    }
}