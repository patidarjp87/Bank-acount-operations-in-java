import java.util.Scanner;

class Address {
    String dno;
    int streetNum;
    String city;
}

class BankAccount {
    static String bankName;
    static String branchName;
    static String ifsc;

    long accNum;
    String accHName;
    double balance;

    Address address;

    static void bankName() {
        System.out.println("Bank Name " + bankName);
    }

    static void branchName() {
        System.out.println("Branch Name " + branchName);
    }

    static void ifsc() {
        System.out.println("Branch ifsc " + ifsc);
    }

    void display() {
        System.out.println("Bank Name " + bankName);
        System.out.println("Branch Name " + branchName);
        System.out.println("Branch ifsc " + ifsc);
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Do not pass negative amount");
        }
        balance += amount;
        alert(amount, " credited to ");
    }

    public double withdraw(double amt) throws IllegalArgumentException, IllegalStateException {
        if (amt <= 0) {
            throw new IllegalArgumentException("Do not pass negative amount");
        }
        if (amt > balance) {
            throw new IllegalStateException("Insufficient balance...!!!");
        }
        balance = balance - amt;
        alert(amt, " debited from ");
        return amt;
    }

    private void alert(double amt, String action) {
        System.out.println("Case " + amt + " is" + action + "your account " + accNum);
        System.out.println("Current Balance in your account  " + balance);
    }

    public void currentBalance() {

        System.out.println("your current account balance is "+balance);
    }

    public void transferMoney(BankAccount destAcc, double amt) throws IllegalArgumentException, IllegalStateException {
        withdraw(amt);
        destAcc.deposit(amt);
        System.out.println("Cash  " +amt+ "  is transfered to  " + destAcc.accNum);
    }
}

public class Bank {
    public static void main(String[] args) {
        // static field initialization
        BankAccount.bankName = "BOI";
        BankAccount.branchName = "indore";
        BankAccount.ifsc = "BKID0008858";

        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();
        BankAccount acc3 = new BankAccount();

        // acc1 instance field initialization
        acc1.accNum = 1234;
        acc1.accHName = "jp";
        acc1.balance = 10000;
        acc1.address = new Address();
        acc1.address.streetNum = 1;
        acc1.address.dno = "1-3/A-7";
        acc1.address.city = "Indore";

        // acc2 instance field initialization
        acc2.accNum = 5678;
        acc2.accHName = "hp";
        acc2.balance = 20000;
        acc2.address = new Address();
        acc2.address.streetNum = 4;
        acc2.address.dno = "1-4/A-2";
        acc2.address.city = "Bhopal";

        // acc3 instance field initialization
        acc3.accNum = 4567;
        acc3.accHName = "pp";
        acc3.balance = 30000;
        acc3.address = new Address();
        acc3.address.streetNum = 8;
        acc3.address.dno = "4/B-8";
        acc3.address.city = "Dhar";
        // **** BUSINESS LOGIC ****
        // deposit
        // withdraw
        // currentBalance
        // transferMoney
        // acc1.deposit(5000);
        // double amount = acc1.withdraw(2000);
        // acc1.currentBalance();
        // acc1.transferMoney(acc2, 5000);
        // Assume that there are three accounts in a bank
        System.out.println("what do you want to do.?");
        int choice=0;
        while(choice!=7)
        {
            System.out.println("\n\npress 1 to know bank details\npress 2 to know your account balance \npress 3 to know customer details\npress 4 to transfer balance\npress 5 to withdraw\npress 6 to deposit \npress  7 to exit");
            Scanner s = new Scanner(System.in);
            choice=s.nextInt();
            switch(choice)
            {
                case 1:
                    acc1.display();
                    break;
                case 2:
                    System.out.println("Enter your account number");
                    int i=s.nextInt();

                    if(i==acc1.accNum)
                    {
                        acc1.currentBalance();
                        break;
                    }
                    else if(i==acc2.accNum)
                    {
                        acc2.currentBalance();break;
                    }
                    else if(i==acc3.accNum)
                    {
                        acc3.currentBalance();break;
                    }
                    else
                    {
                        System.out.println("Invalid account number...!!!");break;
                    }
                case 3:
                    // I will write it later
                    break;
                case 4:
                    System.out.println("Enter your account no.");
                    int j=s.nextInt();
                    System.out.println("Enter beneficier account no.");
                    int destAcc=s.nextInt();
                    System.out.println("Enter amount to transfer ");
                    double amt=s.nextDouble();
                    if(j==acc1.accNum)
                    {
                        if(destAcc==acc2.accNum)
                          acc1.transferMoney(acc2,amt);
                        else if(destAcc==acc3.accNum)
                          acc1.transferMoney(acc3,amt);
                        break;
                    }
                    else if(j==acc2.accNum)
                    {
                        if(destAcc==acc1.accNum)
                        acc2.transferMoney(acc1,amt);
                      else if(destAcc==acc3.accNum)
                        acc2.transferMoney(acc3,amt);
                      break;
                    }
                    else if(j==acc3.accNum)
                    {
                        if(destAcc==acc2.accNum)
                        acc1.transferMoney(acc2,amt);
                       else if(destAcc==acc1.accNum)
                        acc1.transferMoney(acc1,amt);
                      break;
                    }
                    else
                    {
                        System.out.println("Invalid account number...!!!");break;
                    }
                case 5:
                    System.out.println("Enter your account no.");
                    int k=s.nextInt();
                    System.out.println("Enter amount to withdraw ");
                    double amount=s.nextDouble();
                    if(k==acc1.accNum)
                    {
                        acc1.withdraw(amount);
                        break;
                    }
                    else if(k==acc2.accNum)
                    {
                        acc2.withdraw(amount);break;
                    }
                    else if(k==acc3.accNum)
                    {
                        acc3.withdraw(amount);break;
                    }
                    else
                    {
                        System.out.println("Invalid account number...!!!");break;
                    }
                       
                case 6:
                System.out.println("Enter your account no.");
                int l=s.nextInt();
                System.out.println("Enter amount to deposit ");
                double amnt=s.nextDouble();
                if(l==acc1.accNum)
                {
                    acc1.deposit(amnt);
                    break;
                }
                else if(l==acc2.accNum)
                {
                    acc2.deposit(amnt);break;
                }
                else if(l==acc3.accNum)
                {
                    acc3.deposit(amnt);break;
                }
                else
                {
                    System.out.println("Invalid account number...!!!");break;
                }
            
                case 7:
                    
                    break;

                default:
                    System.out.println("Invalid input...");
            }
           
        }
    }
}