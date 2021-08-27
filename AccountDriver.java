import java.util.Scanner;

public class AccountDriver {

    //Entry point of program
    public static void main(String [] args) {
         
        Scanner keyboard = new Scanner(System.in);

        //Create array of Accounts
        Account account [] = new Account[10];
        int numAccount = 0;

        int choice;

        do{
            choice = menu(keyboard);
            System.out.println();

            if(choice == 1){
                account[numAccount++] = createAccount(keyboard);
            } else if (choice == 2){
                doDeposit(account, numAccount, keyboard);
            } else if (choice == 3){
                doWithdraw(account, numAccount, keyboard);
            } else if (choice == 4){
                applyInterest(account, numAccount, keyboard);
            } else {
                System.out.println(" Good Bye ");
            }
            System.out.println();
        }while(choice != 5);
    }
    
    /**
     * Account choice
     * @param keyboard
     * @return choice
     */
        public static int accountMenu(Scanner keyboard){
            System.out.println("Select Account Type: ");
            System.out.println("1. Checking Account");
            System.out.println("2. Saving Account");
            
            int choice;
            do{
                System.out.print("Enter choice: ");
                choice = keyboard.nextInt();
            }while(choice < 1 || choice > 2);
            
            return choice;
        }


        public static  int searchAccount(Account accounts [], int count, int accountNumber){
            for(int i=0; i<count; i++){
                if(accounts[i].getAccountNumber() == accountNumber){
                    return i;
                }
            }
                return -1;
            }

    /**
     * Function to perform Deposit on a selected account
     */
    public static void doDeposit(Account account [], int count, Scanner keyboard){

        //Get the account number
        System.out.println("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(account, count, accountNumber);
   
        if(index >= 0){
            //Amount
            System.out.print("Please enter deposit amount: ");
            double amount = keyboard.nextDouble();

            account[index].deposit(amount);
        }else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }
    
    public static void doWithdraw(Account account [], int count, Scanner keyboard){

        //Get the account number
        System.out.println("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(account, count, accountNumber);
   
        if(index >= 0){
            //Amount
            System.out.print("Please enter Withdraw amount: ");
            double amount = keyboard.nextDouble();

            account[index].withdraw(amount);
        }else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account account [], int count, Scanner keyboard){
        
        //Get the account number
        System.out.println("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(account, count, accountNumber);
   
        // must be instance of saving account
        if(account[index] instanceof SavingAccount){
            ((SavingAccount) account[index]). applyInterest();
        }else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    /**
     * Function to create a new account
     */
    public static Account createAccount(Scanner keyboard){

        Account account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print("Enter Account Number: ");
        accountNumber = keyboard.nextInt();

        if(choice == 1){//checking account
            System.out.print("Enter Transaction Fee: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        }else {         // saving account
            System.out.print("Please enter interest rate: ");
            double ir = keyboard.nextDouble();
            account = new SavingAccount(accountNumber, ir);
        }
        return account;
    }

    /**
     * Menu to display options and get the user's selection
     * @param keyboard
     * @return
     */
    public static int menu(Scanner keyboard){
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do{
            System.out.println("Enter");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 5);

        return choice;
    }
}

