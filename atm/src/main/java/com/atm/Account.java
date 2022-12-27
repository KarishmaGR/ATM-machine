package com.atm;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;





public class Account  {
    //Variables
    private int customerNumber;
    private int pinNumber;
    private Double checkingBalance = 0.0;
    private Double SavingBalance = 0.0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat(" `$`###,##0.00");


    public Account(){

    }

    public Account(int customerNumber,int pinNumber){
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }

    public Account(int customerNumber,int pinNumber,Double checkingBalance, Double SavingBalance){
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.SavingBalance = SavingBalance;

    }

    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustmoreNumber(){
        return customerNumber;

    }

    //Set pin Number
    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    //Get pin NUmber
    public int getPinNumber(){
        return pinNumber;
    }

    //Get Checking Balance

    public double getCheckingBalance(){
        return checkingBalance;
    }

    //get Saving Balance
    public Double getSavingBalance(){
        return SavingBalance;
    }


    //calculate Checking Withdraw
    public double calCheckigngWithdrawal(Double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    //calculate Saving withdraw 
    public double calSavingWithdraw(double amount){
        SavingBalance = (SavingBalance - amount);
        return SavingBalance;
    }

    //calculate checking deposite
    public double calcheckingDeposite(double amount){
        checkingBalance = (checkingBalance+amount);
        return checkingBalance;
    }

    //calculating Saving Deposite
    public double calSavingDeposite(double amount){
        SavingBalance = (SavingBalance+ amount);
        return SavingBalance;
    }


    //calsulate checking Transfer
    public void calcheckingTransfer(double amount){
        checkingBalance = checkingBalance - amount;
        SavingBalance = SavingBalance + amount;
    }


    //Checking Saving Transfer
    public void calSavingTranfer(double amount){
        SavingBalance = SavingBalance - amount;
        checkingBalance = checkingBalance + amount;
    }

    // Get Checking Withdrawal Input 

    public void getCheckingWithdrawInput(){
        boolean end =  false;
        while(!end){
            try{
                System.out.println("\nCurrent checking account Balance :"+ moneyFormat.format(checkingBalance));
                System.out.println("\n Amount you want to withdraw from Checking Account:");
                double amount = input.nextDouble();
                if((checkingBalance - amount )>= 0 && amount >=0){
                    calCheckigngWithdrawal(amount);
                    System.out.println("\ncurrnet Checking Account Balance: "+ moneyFormat.format(checkingBalance));
                    end = true;
                }
                else{
                    System.out.println("\n Balance can not be negetive .");

                }

            }catch(InputMismatchException e){
                System.out.println("\n Invalid choice.");
                input.next();
            }
        }
    }

    public void getSavingWithdrawInput(){
        boolean end  = false;
        while(!end){
            try{
                System.out.println("\ncurrent Saving Account Balance: " + moneyFormat.format(SavingBalance));
                System.out.println("\nAmount you want to withdraw from saving Account: ");
                double amount = input.nextDouble();
                if((SavingBalance-amount)>= 0 && amount >=0){
                    calSavingWithdraw(amount);
                    System.out.println("\n Current Saving Account Balance :" + moneyFormat.format(SavingBalance));
                    end = true;


                }else{
                    System.out.println("\n Balance can not be negetive.");

                }




            }catch(InputMismatchException e){
                System.out.println("\n Invalid Choice.");
                input.next();
            }
        }
    }




    // get Checking Deposite Input

    public void getCheckingDepositeInput(){
        boolean end = false;
        while(!end){
            try{
                System.out.println("\nCurrent Checking account Balance: "+ moneyFormat.format(checkingBalance));
                System.out.println("\nAmount you want to deposite from checking Account: ");
                double amount = input.nextDouble();
                if((checkingBalance +amount)>=0 && amount>=0){
                    calcheckingDeposite(amount);
                    System.out.println("\nCurrent checking account balance :"+ moneyFormat.format(checkingBalance));
                    end = true;
                }
                else{
                    System.out.println("\nBalance can not be negetive.");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }



 // Get Saving Deposite Info
 public void getSavingDepositeInput(){
    boolean end = false;
     while(!end){
        try{
            System.out.println("\n Current Saving Account Balace :"+ moneyFormat.format(SavingBalance));
            System.out.println("\nAmount you want to deposite into your saving account:");
            double amount = input.nextDouble();

            if((SavingBalance + amount )>= 0 && amount>=0){
                calSavingDeposite(amount);
                System.out.println("\nCurrent Saving Account Balance: "+moneyFormat.format(SavingBalance));
                end = true;
            }else{
                System.out.println("\nBalance can not be negetive.");
            }
        }catch(InputMismatchException e){
            System.out.println("\nInvalid Choice.");
            input.next();
        }
     }
}
  


//Get Transfer Input 
public void getTransferInput(String accType){
   boolean end = false;
   while(!end){
    try{
        if(accType.equals("checkings")){
            System.out.println("\nSelect an account you want to transfer fund to:");
            System.out.println("1. Saving");
            System.out.println("2. Exit");
            System.out.println("\nChoice:");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                         System.out.println("\nCurrent checking account balance: "+moneyFormat.format(checkingBalance) );
                         System.out.println("\nAmount you want to transfer into your saving Account: ");
                         double amount = input.nextDouble();
                         if((SavingBalance+amount)>=0 && (checkingBalance-amount)>=0 && amount>=0){
                            calcheckingTransfer(amount);
                            System.out.println("\n Current Saving Account Balance: "+ moneyFormat.format(SavingBalance));
                            System.out.println("\n Current Checking Account balance : "+moneyFormat.format(checkingBalance));
                            end = true;
                         }else{
                            System.out.println("\nBalance Can not Be Negetive.");
                         }
                         break;
                case 2:
                   return;

                default:
                System.out.println("\nInvalid choice.");
                break;
            }

        }else if(accType.equals("Savings")){
            System.out.println("\nSelect an account you wish to transfer fund to: ");
            System.out.println("1. Saving");
            System.out.println("2. Exit");
            System.out.println("\nChoice:");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                          System.out.println("\n Current Saving account Balance : "+ moneyFormat.format(SavingBalance));
                          System.out.println("\nAmount you want to deposite into your saving Account: ");
                          double amount = input.nextDouble();
                          if((checkingBalance + amount)>=0 && (SavingBalance - amount )>=0&&amount>=0){
                            calSavingTranfer(amount);
                            System.out.println("\nCurrent checking account balance: "+ moneyFormat.format(checkingBalance));
                            System.out.println("\n Currnet saving Account Balance : "+ moneyFormat.format(SavingBalance));
                            end = true;

                          }else{
                            System.out.println("\nBalance can not be negetive.");
                          }
                          break;
                 case 2:
                 return;
                 
                 default:
                 System.out.println("\nInvalid Choice.");
                 break;
            }
        }
    }catch(InputMismatchException e){
        System.out.println("\nInvalid Choice.");
        input.next();
    }
   }
}


}
