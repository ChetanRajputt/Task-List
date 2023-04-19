package atm;

import java.util.Scanner;

class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float  balance=1000f;
    int    transaction =0;
    String transactionHistory = "";
    
    //registraction
    public void register(){
        Scanner in = new Scanner(System.in);
        System.out.print("\n Enter your Full Name - ");
        this.name =in.nextLine();
        System.out.print("\n Enter your Username - ");
        this.userName =in.nextLine();
        System.out.print("\n Enter your Password - ");
        this.password =in.nextLine();
        System.out.print("\n Enter your Account Number - ");
        this.accountNo =in.nextLine();
        System.out.print("\n Registraction completed - ");
    }
    
    //login
    public boolean login(){
        boolean isLogin = false;
        Scanner in = new Scanner(System.in);   
         while(!isLogin){
             System.out.print("\n Enter your Username - ");
             String UserName = in.nextLine();
             if(UserName.equals(userName) ){
                 while(!isLogin){
                     System.out.print("\n Enter your Password - ");
                     String Password = in.nextLine();
                     if(Password.equals(password) ){
                         System.out.println("\nLogin Successful!!");
                         isLogin = true;
                     }
                     else{
                         System.out.println("\nIncorrect Password!!");
                     }
                 }
             }
             else{
                 System.out.println("\nUserName"+UserName+" is  not Found!!");
             }
         }
       return isLogin;
    }
    
    //    Deposit
    public void deposit(){
        
        
        System.out.println("\n Enter Amount to Deposit ");
        Scanner in = new Scanner(System.in);
        float amount = in.nextFloat();
        
        try
        {
          if(amount <= 100000f){
              transaction++;
              balance +=amount;
                System.out.println("\n Deposit Succesfully...");
                String str = amount + "Rs Deposit\n ";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                 System.out.println("\n Soory Limit is 100000.00");
              }
        }
        catch(Exception e )
        {   
        }
    }

   // withdraw
    public void withdraw(){
      
        Scanner in = new Scanner(System.in);
        System.out.print("\n Enter Amount to Withdraw - ");
        float amount = in.nextFloat();
        try{
            if(balance >= amount){
                transaction++;
                balance -= amount;
                System.out.println("\n Withdraw Succesfully...");
                String str = amount + "Rs Withdrawed\n ";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                 System.out.println("\n Insufficient Balance");          
              }
        }
        catch(Exception e){   
        }
    }
    
    //transfer
    public void transfer(){
        
        System.out.println("\n Enter Receipent's Name ");
        Scanner in = new Scanner(System.in);
        String receipent = in.nextLine();
        float amount = in.nextFloat();
         System.out.println("\n Enter Amount to transfer ");
         float Amount = in.nextFloat();
       try
       {
          if( balance >= amount ){  
              if(amount <= 50000f){
              transaction++;
              balance -=amount;
                System.out.println("\n Succesfully Transfered to "+receipent);
                String str = amount + "Rs transfered to "+receipent+"\n ";
                transactionHistory = transactionHistory.concat(str);
               }
               else{
                 System.out.println("\n Soory Limoi is 50000.00");
               }
          }
          else{
              System.out.println("\n Insufficient Balance");             
          }
       }
       catch(Exception e )
       {
       }
    }
    
    
    //Check balance
    public void checkbalance(){
           System.out.println("\nBalance : "+balance+"RS");         
    }
    
    //transaction history
    public void trHistory(){
        if(transaction == 0){
               System.out.println("\n Empty");          
        }
        else{
               System.out.println("\n transactionHistory");          
        }
    }
    
    
}



public class ATM {

    public static int takeIntInput (int Lmt) {
        int Input  = 0;
        boolean user =false;
        Scanner in = new Scanner(System.in);   
         while(!user){
             try{
                 Input = in.nextInt();
                 user=true;
             
                 if(user && Input > Lmt || Input < 1 ){
                     System.out.print("\n Choose the number between 1 to "+Lmt);
                     user = false;
                  }
             }
             catch(Exception e){
                 System.out.print("\n Enter only Integer value");
                 user =false;
             }
         }    
       return Input;
        
    }

    
    
    public static void main(String[] args) {
        
        System.out.println("~~~~~WELCOME TO ATM SYSTEM~~~~~");
        System.out.println("1) Register \n 2) Exit");
        System.out.print("\n Please enter your choice - ");
        int choice = takeIntInput(2);
        
        if(choice == 1){
            BankAccount b = new BankAccount();
            b.register();
            while(true){
                System.out.println("1) Login \n 2) Exit");
                System.out.print("\n Please enter your choice - ");
                 int ch = takeIntInput(2);
                  if(ch == 1){
                      if(b.login()){
                        System.out.println("~~~~~WELCOME Back "+b.name +"~~~~~\n");
                          boolean inFinish = false;
                   while(!inFinish){
                       System.out.println("1)\nWithdraw 2)\nDeposit 3)\nTransfer 4)\n Check Balance 5)\n Transaction History 6)\n EXIT");
                       System.out.print("\n Enter your choice - ");
                       int C =takeIntInput(6);
                       switch(C){
                           case 1:
                               b.withdraw();
                               break;
                           case 2:
                               b.deposit();
                               break;
                           case 3:
                               b.transfer();
                               break;
                           case 4:
                               b.checkbalance();
                               break;
                           case 5:
                               b.trHistory();
                               break;
                           case 6:
                               inFinish = false;
                               break;    
                       } 
                   }              
                }
            }
            else{
                System.out.println("Please Come again....");
                 System.exit(0);
            }
        }    
     }
      else{
           System.exit(0);
          }      
    }
    
}
