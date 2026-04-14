public abstract class BankAccount {
    private String accountHolder;
    private double balance;


    public BankAccount(String accountHolder, double initialDeposit) {
        // TODO: Initialize the instance variables
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    
   public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposited $" + amount;
        } else {
            return "Invalid deposit amount.";
        }
    }

    /**
     * Abstract method: Child classes must implement this.
     */
    public abstract String withdraw(double amount);

   
    // --- GETTERS AND SETTERS ---
    
    public String getAccountHolder() {
        // TODO: Return the account holder name
        return accountHolder; // Placeholder
    }

    public double getBalance() {
        // TODO: Return the current balance
        return balance; // Placeholder
    }

    protected void setBalance(double balance) {
        // TODO: Set the balance
        this.balance = balance;
    }
}