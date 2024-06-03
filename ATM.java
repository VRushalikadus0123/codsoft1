import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount
 {
    private double balance;

    public BankAccount(double initialBalance) 
	{
        this.balance = initialBalance;
    }

    public double getBalance()
	{
        return balance;
    }

    public void deposit(double amount)
	{
        balance += amount;
    }

    public boolean withdraw(double amount) 
	{
        if (balance >= amount) 
		{
            balance -= amount;
            return true;
        } 
		else
			{
            return false;
        }
    }
}

// Class to represent the ATM machine
public class ATM 
{
    private BankAccount userAccount;

    public ATM(BankAccount account) 
	{
        this.userAccount = account;
    }

    public void withdraw(double amount) 
	{
        if (userAccount.withdraw(amount))
			{
            System.out.println("Withdrawal successful. Please take your cash.");
        } 
		else 
		{
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void deposit(double amount)
	{
        userAccount.deposit(amount);
    }

    public void checkBalance()
	{
        System.out.println("Your current balance is:RS" + userAccount.getBalance());
    }

    public static void main(String[] args) 
	{
        BankAccount account = new BankAccount(1000); // Initial balance set to RS 1000
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();

            switch (option)
			{
                case 1:
                    System.out.print("Enter the amount to withdraw: RS");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: RS");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
