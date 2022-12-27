package com.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;




public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("`$`###,##0.00");
    HashMap<Integer,Account> data = new HashMap<Integer,Account>();


    public void getLogin() throws IOException{
        boolean end = false;
        int customerNumber = 0;
        int pinNumber = 0;
        while(!end){
            try{
                System.out.println("\nEnter your customer Number:");
                customerNumber = menuInput.nextInt();
                System.out.println("\nEnter your Pin Number");
                pinNumber = menuInput.nextInt();
                Iterator it = data.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry pair = (Map.Entry) it.next();
                    Account acc = (Account) pair.getValue();
                    if(data.containsKey(customerNumber) && pinNumber ==acc.getPinNumber()){
                        getAccountType(acc);
                        end = true;
                        break;
                    }
                }
                if(!end){
                    System.out.println("\nWrong customer Number or Pin Number");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid character(s).only Numbers.");
            }
        }
    }

    public void getAccountType(Account acc){
        boolean end = false;
        while(!end){
            try{
                System.out.println("\n Select the Account you want to access:");
                System.out.println("Type 1 - Checking Account");
                System.out.println("Type 2 -Saving Account");
                System.out.println(" Type 3 -Exit");
                System.out.println("\n Choice:");
                  

                int selection = menuInput.nextInt();
                switch(selection){
                    case 1:
                    getChecking(acc);
                    break;
                    case 2:
                    getSaving(acc);
                    break;
                    case 3:
                    end = true;
                    break;
                    default:
                    System.out.println("\n Invalid Choice.");
                }
            }

            catch(InputMismatchException e){
                System.out.println("\n Invalid Choice");
                menuInput.next();

            }
        }
    }

    public void getChecking(Account acc){
        boolean end = false;
        while(!end){
             try{
                System.out.println("\n Checking Account: ");
                System.out.println(" Type 1 -View Balance");
                System.out.println("Type 2 - Withdraw Funds");
                System.out.println("Type 3 - Deposit Fund");
                System.out.println("  Type 4 - Transfer Fund");
                System.out.println("Type 5 - Exit");
                System.out.println("\n Choice:");
                  

                int selection = menuInput.nextInt();
                switch(selection){
                    case 1:
                    System.out.println("\n Checking Account Balance :"+moneyFormat.format(acc.getCheckingBalance()));
                    break;

                    case 2:
                    acc.getCheckingWithdrawInput();
                    break;

                    case 3:
                      acc.getCheckingDepositeInput();
                      break;

                    case 4:
                    acc.getTransferInput("checkings");
                    break;
                     
                    case 5:
                      end = true;
                      break;
                    
                    default:
                      System.out.println("\nInvalid choice.");

                }
             }catch(InputMismatchException e){
                System.out.println("\n Invalid Choice");
                menuInput.next();
             }


        }
    }


    public void getSaving(Account acc){
        boolean end = false;
        while(!end){
            try{
                System.out.println("\nSaving Account: ");
                System.out.println("Type 1 - View Balance ");
                System.out.println(" Type 2 -Withdraw Funds ");
                System.out.println(" Type 3 - Deposite Funds ");
                System.out.println("Type 4 - Transfer Funds ");
                System.out.println("Type 5 - Exit");
                System.out.println("Choice: ");
                int selection = menuInput.nextInt();
                switch(selection){
                    case 1:
                    System.out.println("\n Saving Account balance :"+ moneyFormat.format(acc.getSavingBalance()));
                    break;
                    case 2:
                    acc.getSavingWithdrawInput();
                    break;
                    case 3:
                    acc.getSavingDepositeInput();
                    break;
                    case 4:
                    acc.getTransferInput("Savings");
                    break;
                    case 5:
                    end = true;
                    break;
                default:
                System.out.println("\nInvalid Choice");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
    }

    public void CreateAccount()throws IOException{
        int cst_no = 0;
        boolean end = false;
        while(!end){
            try{
                System.out.println("\n Enter your Customer Number:");
                cst_no = menuInput.nextInt();
                 Iterator it = data.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry pair = (Map.Entry) it.next();
                    if(!data.containsKey(cst_no)){
                        end = true;
                    }
                }
                if(!end){


                    System.out.println("\ncustomer Id is Already registered");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid Choice:");
                menuInput.next();
            }
        }

        System.out.println("\nEnter Pin to be registered");
        int pin = menuInput.nextInt();
        data.put(cst_no, new Account(cst_no,pin));
        System.out.println("\n your new Account has been successfully Registered! ");
        System.out.println("\nRedirection to Login.............");
        getLogin();



    }

    /**
     * @throws IOException
     */
    public void mainMenu() throws IOException{
        data.put(952141, new Account(952,904,1000.0,5000.0));
        data.put(123,new Account(123,123,20000.0,5000.0));
        boolean end = false;
        while(!end){
            try{
                System.out.println("\n Type 1- Login");
                System.out.println(" Type 2 - Create Account:");
                System.out.println("\nChoice:");
                int choice = menuInput.nextInt();
                switch(choice){
                    case 1:
                    getLogin();
                    end = true;
                    break;
                    case 2:
                    CreateAccount();
                    end = true;
                    break;
                    default:
                    System.out.println("\n Invalid Choice.");

                }

            }catch(InputMismatchException e){
                System.out.println("\n Invalid Choice.");
                menuInput.next();
            }
        }

        System.out.println("\n Thank you for Using this ATM.\n");
        menuInput.close();
        System.exit(0);
    }
    
}
