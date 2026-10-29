import java.util.ArrayList;
import java.util.List;


class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double currentBalance;

    
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (initialBalance >= 0) {
            this.currentBalance = initialBalance;
        } else {
            this.currentBalance = 0.0;
        }
    }


    public void deposit(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            System.out.println(" done"+ amount + accountNumber);
        } else {
            System.out.println("error");
        }
    }

  
    public void withdraw(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            System.out.println( amount +  accountNumber);
        } else {
            System.out.println("error");
        }
    }

    
    public double getBalance() {
        return currentBalance;
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= currentBalance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println(  amount );
        } else {
            System.out.println(" amount not aviable");
        }
    }

    
    public void displayAccountInfo() {
        System.out.println(  accountNumber  + accountHolderName  + currentBalance);
    }

    // الحصول على رقم الحساب
    public String getAccountNumber() {
        return accountNumber;
    }
}

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }
    public void addAccount(BankAccount newAccount) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(newAccount.getAccountNumber())) {
                System.out.println("is account is aviable");
                return;
            }
        }
        accounts.add(newAccount);
        System.out.println( "add account ");
    }

    // إزالة حساب من البنك
    public void removeAccount(String accountNumber) {
        BankAccount target = findAccount(accountNumber);
        if (target != null) {
            accounts.remove(target);
            System.out.println(  accountNumber );
        } else {
            System.out.println(" error");
        }
    }

  
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    
    public void displayDetails() {
        if (accounts.isEmpty()) {
            System.out.println(" no accounts ");
        } else {
            System.out.println("accounts ");
            for (BankAccount acc : accounts) {
                acc.displayAccountInfo();
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
     
        Bank myBank = new Bank();

     
        BankAccount acc1 = new BankAccount("ACC101", "mohyee", 5000.0);
        BankAccount acc2 = new BankAccount("ACC102", "hamza", 3000.0);

       
        myBank.addAccount(acc1);
        myBank.addAccount(acc2);

        System.out.println("\n-----------------");
  
        myBank.displayDetails();

        System.out.println("\n-----------------");
       
        acc1.deposit(1000.0);
        acc1.withdraw(2000.0);

        System.out.println("\n-----------------");
        
        myBank.displayDetails();
    }
}