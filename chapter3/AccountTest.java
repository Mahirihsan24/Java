import java.util.Scanner;
public class AccountTest {
    public static void main(String[] args) {
        
        Account account1 = new Account("Ishfak Akbar",100);
        Account account2 = new Account("Mahir Ihsan",200);
        
        System.out.println(account1.getName()+" : "+account1.getBalance());
        System.out.println(account2.getName()+" : "+account2.getBalance());
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter account1 deposit amount : ");
        double depositAmount = input.nextDouble();
        account1.deposit(depositAmount);
        System.out.println("Enter account2 deposit amount : ");
        depositAmount = input.nextDouble();
        account2.deposit(depositAmount);
        
        System.out.println(account1.getName()+" : "+account1.getBalance());
        System.out.println(account2.getName()+" : "+account2.getBalance()); 
    }
}