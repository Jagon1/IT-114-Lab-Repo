import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: Create a Scanner to read input
        Scanner scanner= new Scanner(System.in);
        
        // TODO: Ask for User Name and Initial Deposit
        System.out.println("Enter account holder name");
        String name= scanner.nextLine();
        
        // TODO: Ask user to select Checking or Savings
        System.out.println("Select Checking(1) or Savings(2): ");
        String accountType= scanner.nextLine();
        
        // TODO: Instantiate the correct account type based on input
        BankAccount account;
        if(accountType=="1"){
            account= new CheckingAccount(name, 0.0);
        }else {
            account= new SavingsAccount(name,0.0);
        }
        
        // TODO: Create a loop (while) that displays a menu:
        while(true){
            System.out.println("Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String optionChosen = scanner.nextLine();
        // 1. Deposit
            if (optionChosen.equals("1")) {
                System.out.print("Enter deposit amount: ");
                double depositAmount = Double.parseDouble(scanner.nextLine());
                account.deposit(depositAmount);
                System.out.println("Deposited: $" + depositAmount);
            }
        // 2. Withdraw
            if (optionChosen.equals("2")) {
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = Double.parseDouble(scanner.nextLine());
                account.withdraw(withdrawAmount);
                System.out.println("Withdrew: $" + withdrawAmount);
            }
        // 3. Check Balance
                if (optionChosen.equals("3")) {
                System.out.println("Current Balance: $" + account.getBalance());
            }
        // 4. Exit
                if (optionChosen.equals("4")) {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }
}