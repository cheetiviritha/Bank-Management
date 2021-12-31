import java.util.Scanner;

class Bank{
	private String accno,name;
	private long balance;
	Scanner sc=new Scanner(System.in);
	
	void openAccount() {							//open account
		System.out.print("Enter Account No: ");
		accno=sc.next();
		System.out.print("Enter Name: ");
		name=sc.next();
		System.out.print("Enter Amount");
		balance=sc.nextLong();
	}
	
	void Display() {								//to display
		System.out.println(accno + "," + name + "," + balance);
	}
	
	void deposit() {								//to deposit
		long amt;
		System.out.println("Enter amount u want to deposit: ");
		amt=sc.nextLong();
		balance=balance+amt;
		
	}
	
	 void withdrawal() {
	        long amt;
	        System.out.println("Enter Amount U Want to withdraw : ");
	        amt = sc.nextLong();
	        if (balance >= amt) { 
	            balance = balance - amt;
	        } 
	        else {
	            System.out.println("Transaction Failed... Due to low balance");
	        }
	    }
	 boolean search(String acn) {
	        if (accno.equals(acn)) 
	        {
	            Display();
	            return (true);
	        }
	        return (false);
	    }
	
}
public class Main_Bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 	System.out.print("How Many Customer U Want to Input : ");
	        int n = sc.nextInt();
	        Bank C[] = new Bank[n];
	        for (int i = 0; i < C.length; i++) 
	        {
	            C[i] = new Bank();
	            C[i].openAccount();
	        }
	        
	        int ch;
	        do {
	            System.out.println("Main Menu\n1. Display All\n 2. Display By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
	                System.out.println("Ur Choice :"); 
	                ch = sc.nextInt();
	                switch (ch) {
	                    case 1:
	                        for (int i = 0; i < C.length; i++) {
	                            C[i].Display();
	                        }
	                        break;

	                    case 2:
	                        System.out.print("Enter Account No U Want to Search...: ");
	                        String acn = sc.next();
	                        boolean found = false;
	                        for (int i = 0; i < C.length; i++) {
	                            found = C[i].search(acn);
	                            if (found) {
	                                break;
	                            }
	                        }
	                        if (!found) {
	                            System.out.println("Search Failed..Account Not Exist..");
	                        }
	                        break;

	                    case 3:
	                        System.out.print("Enter Account No : ");
	                        acn = sc.next();
	                        found = false;
	                        for (int i = 0; i < C.length; i++) {
	                            found = C[i].search(acn);
	                            if (found) {
	                                C[i].deposit();
	                                break;
	                            }
	                        }
	                        if (!found) {
	                            System.out.println("Search Failed..Account Not Exist..");
	                        }
	                        break;

	                    case 4:
	                        System.out.print("Enter Account No : ");
	                        acn = sc.next();
	                        found = false;
	                        for (int i = 0; i < C.length; i++) {
	                            found = C[i].search(acn);
	                            if (found) {
	                                C[i].withdrawal();
	                                break;
	                            }
	                        }
	                        if (!found) {
	                            System.out.println("Search Failed..Account Not Exist..");
	                        }
	                        break;

	                    case 5:
	                        System.out.println("Good Bye..");
	                        break;
	                }
	            }
	            while (ch != 5);
	}

}