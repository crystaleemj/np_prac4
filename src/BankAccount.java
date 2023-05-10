
public class BankAccount {
    
    String accountNum = "";
    String accountName = "";
    double balance = 0;
    
    public BankAccount() {
    }

    public BankAccount(String accountNum, String accountName, double balance) {
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amt){
        balance += amt;
        System.out.println("your new balance is: " + balance);
    }

    public boolean withdraw(double amt){
        if (amt > balance){
        System.out.println("insufficient fund");
        return false;
        } else {
            balance -= amt;
            System.out.println("Your new balance is: " + balance);
            return true;
        }
    }

    

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount [accountNum=" + accountNum + ", accountName=" + accountName + ", balance=" + balance + "]";
    }

    
    

}
