public class SavingsAccount extends BankAccount{

    double rate = 0;

    public SavingsAccount() {
    }

    public SavingsAccount(String accountNum, String accountName, double balance, double rate) {
        super(accountNum, accountName, balance);
        this.rate = rate;
    }

    public double calculate(){
        double interest = balance * (rate/100);
        return interest;
    }

    
    @Override
    public String toString() {
        return "SavingsAccount [accountNum=" + accountNum + ", accountName=" + accountName + ", balance=" + balance + ", rate=" + rate +"]";
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    
}
