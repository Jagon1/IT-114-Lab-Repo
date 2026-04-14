public class CheckingAccount extends BankAccount {
    private final double OVERDRAFT_FEE = 35.00;

    public CheckingAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'
        super(accountHolder, initialDeposit);
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Invalid withdrawal amount.";
        }
        double balance = getBalance();
        if (amount <= balance) {
            setBalance(balance - amount);
            return String.format("Withdrew $%.2f. New Balance: $%.2f", amount, getBalance());
    }
        double fee = 35.00;
        double newBalance = balance - amount - fee;
        setBalance(newBalance);
        return String.format("Overdraft! $%.2f fee applied. New Balance: $%.2f", fee, newBalance
    );
}
}