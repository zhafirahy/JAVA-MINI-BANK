// Saving account child class
// has an interest rate
// a method to apply interest - profit

public class SavingAccount extends Account {

    // interest rate
    private double interestRate;


    //default constructor
    public SavingAccount(){
        super();
    }

    /**
     * Parameter constructor to initialize Saving Account
     * with a custom customer Account Number and interest rate
     */
    public SavingAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    //getter function
    public double getInterestRate(){
        return this.interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double calcInterest(){
        return balance = interestRate;
    }

    public void applyInterest(){
        double interest = calcInterest();
        System.out.printf(" Interest amount %.2f added to balance%n", interest);
        deposit(interest);
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

            if((amount) <= balance) {
                System.out.printf(" Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf(" Current Balance is : %.2f%n" , balance);
            }
        } else {
            System.out.println(" Negative amount cant be withdrawn!");
        }
    }
}

