import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static List<SavingsAccount> savingsAccList = new ArrayList<>();
    static String fileN = "savings_account.csv";

    public static void main(String[] args) throws Exception {

        
        initAcc(fileN);
        displayMenu();
    }

    public static void initAcc(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String a = br.readLine();

        while ((a = br.readLine()) != null) {
            String[] b = a.split(",");
            savingsAccList.add(new SavingsAccount(b[0], b[1], Double.parseDouble(b[2]), Double.parseDouble(b[3])));

        }
    }

    public static void displayMenu() throws IOException {
        Scanner scan = new Scanner(System.in);

        // -1 is the equivalent to null
        int input = -1;

        while (input != 0) {
            System.out.println("[1] Display All Accounts");
            System.out.println("[2] Deposit");
            System.out.println("[3] Withdraw");
            System.out.println("[0] Exit");
            System.out.print("Enter Option:");

            input = scan.nextInt();

            if (input == 1) {
                DisplayAll(savingsAccList);
            }

            if (input == 2) {
                System.out.print("Enter the account number: ");
                String a = scan.next();

                // assigning the object to a var
                SavingsAccount sa = SearchAcc(savingsAccList, a);

                if (sa == null) {
                    System.out.println("Unable to find account number. Please try again");
                } else {
                    System.out.print("Amount to deposit: ");
                    double amt = scan.nextDouble();
                    sa.deposit(amt);
                    writeFile();
                    System.out.println(amt + " deposited successfully");
                    System.out.println("Acc No: " + sa.getAccountNum() + "  " + "Acc Name: " + sa.getAccountName()
                            + "  " + "Balance: " + sa.getBalance() + "  " + "Rate: " + sa.getRate());

                }
            }

            if (input == 3) {
                System.out.print("Enter the account number: ");
                String b = scan.next();

                SavingsAccount sa = SearchAcc(savingsAccList, b);
                if (sa != null) {

                    System.out.print("Amount to withdraw: ");
                    double c = scan.nextDouble();

                    if (sa.withdraw(c)){
                        writeFile();
                    System.out.println(c + " withdrawn successfully");
                    System.out.println("Acc No: " + sa.getAccountNum() + "  " + "Acc Name: " + sa.getAccountName()
                            + "  " + "Balance: " + sa.getBalance() + "  " + "Rate: " + sa.getRate());
                    }
                } else {

                    System.out.println("Unable to find account number. Please try again");
                }

            }
            
        } System.out.println("Good bye!");
        System.exit(0);

    }

    static SavingsAccount SearchAcc(List<SavingsAccount> sList, String accNo) {
        // search for account based acc num
        // return savacc obj if acc found, else null
        for (SavingsAccount s : sList) {
            if (s.getAccountNum().equals(accNo)) {
                return s;
            }
        }
        return null;
    }

    static void writeFile() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileN,false));
        bw.write("Acc No,Acc Name,Balance,Rate");

        for (SavingsAccount s1 : savingsAccList){
            bw.newLine();
            bw.write(s1.getAccountNum()+ "," + s1.getAccountName() + "," + s1.getBalance() + "," + s1.getRate());
            
        } bw.flush();
       

    }

    static void DisplayAll(List<SavingsAccount> sList) {
        for (SavingsAccount item : sList) {
            System.out.println("Acc no: " + item.getAccountNum() + " Acc name: " + item.getAccountName() + " Balance: "
                    + item.getBalance() + " Rate: " + item.getRate());
        }

    }
}