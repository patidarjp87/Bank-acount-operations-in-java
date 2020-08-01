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
        System.out.println("Bank Name" + bankName);
    }

    static void branchName() {
        System.out.println("Branch Name" + branchName);
    }

    static void ifsc() {
        System.out.println("Branch ifsc" + ifsc);
    }

    void display() {
        System.out.println("Bank Name" + bankName);
        System.out.println("Branch Name" + branchName);
        System.out.println("Branch ifsc" + ifsc);
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Do not pass negative amount");
        }
        balance += amount;
        alert(amount, "credited to");
    }

    public double withdraw(double amt) throws IllegalArgumentException, IllegalStateException {
        if (amt <= 0) {
            throw new IllegalArgumentException("Do not pass negative amount");
        }
        if (amt > balance) {
            throw new IllegalStateException("Insufficient balance...!!!");
        }
        balance = balance - amt;
        alert(amt, "debited from");
        return amt;
    }

    private void alert(double amt, String action) {
        System.out.println("Case" + amt + "is" + action + "your account " + accNum);
        System.out.println("Current Balance in your account " + balance);
    }

    public void currentBalance() {

        System.out.println(balance);
    }

    public void transferMoney(BankAccount destAcc, double amt) throws IllegalArgumentException, IllegalStateException {
        withdraw(amt);
        destAcc.deposit(amt);
        System.out.println("Cash " + amt + " is transfered to " + destAcc.accNum);
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
        acc1.deposit(5000);
        double amount = acc1.withdraw(2000);
        acc1.currentBalance();
        acc1.transferMoney(acc2, 5000);
    }
}