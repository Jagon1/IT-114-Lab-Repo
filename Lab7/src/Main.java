import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        // TODO: Create a GUI using javax.Swing and JFrames, Panels, etc
        BankGUI gui = new BankGUI();
    }
}
class BankGUI extends JFrame {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public BankGUI() {
        setupAccount();
        buildDashboard();
    }
    private void setupAccount() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        String depositStr = JOptionPane.showInputDialog("Enter initial deposit:");
        double deposit = 0;
        try {
            deposit = Double.parseDouble(depositStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
            deposit = 0;
        }
        String[] options = {"Checking", "Savings"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose account type:",
                "Account Type",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (choice == 0) {
            account = new CheckingAccount(name, deposit);
        } else if (choice == 1) {
            account = new SavingsAccount(name, deposit);
        } else {
            account = new CheckingAccount(name, deposit);
        }
    }
    private void buildDashboard() {
        setTitle("Bank Account GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        JLabel headerLabel = new JLabel("Welcome, " + account.getAccountHolder() + "!");
        balanceLabel = new JLabel(String.format("Current Balance: $%.2f", account.getBalance()));
        amountField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String message = account.deposit(amount);
                balanceLabel.setText(String.format("Current Balance: $%.2f", account.getBalance()));
                JOptionPane.showMessageDialog(this, message);
                amountField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Please enter a valid number");
            }
        });
        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String message = account.withdraw(amount);
                balanceLabel.setText("Balance: $" + account.getBalance());
                JOptionPane.showMessageDialog(this, message);
                amountField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Please enter a valid number");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
        panel.add(headerLabel);
        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(exitButton);
        add(panel);
        setVisible(true);
    }
}