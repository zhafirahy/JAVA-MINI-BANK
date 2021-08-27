//Checking Account

public class CheckingAccount extends Account{

    // Default Transaction Fee
    private static double FEE = 2.5;

    //default constructor
    public CheckingAccount(){
        super();
    }

    /**
     * Parameter constructor to initialize CheckingAccount
     * with a custom Account Number and Custom Transaction
     * Fee
     */
    public CheckingAccount(int accountNumber, double fee){
        super(accountNumber);
        FEE = fee;
    }


    /**
     * Function to deposit funds into the account as long as
     * the amount parameter is >0
     * 
     * Apply transaction fee for the CheckingAccount 
     * @param amount value to be deposited
     */
    public void deposit(double amount){

        //First Check Amount
        if( amount >0){
            balance += amount;
            System.out.printf(" Amount %.2f deposited%n" , amount);

            //Apply Transaction Fee
            balance -= FEE;
            System.out.printf(" Fee %.2f Applied%n" , FEE);
            System.out.printf(" Current Balance is : %2f%n" , balance);


        } else {
            System.out.println(" A negative amount cant be deposited");
        }
    }

    /**
     * Function to withdraw funds from the Account as long as
     * 1. amount to withdraw must be >0
     * 2. amount to withdraw must be = balance
     * 
     * @param amount value to be withdrawn
     */
    public void withdraw(double amount){

        //Same Check
        if(amount >0){
            //Check sufficiant balance

            if((amount+FEE) <= balance) {
                System.out.printf(" Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf(" Fee of %.2f applied%n" , FEE);
                System.out.printf(" Current Balance is : %.2f%n" , balance);
            }
        } else {
            System.out.println(" Negative amount cant be withdrawn!");
        }
    }
}
