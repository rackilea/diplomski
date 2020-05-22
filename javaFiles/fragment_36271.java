public class Retiring extends Employee{
     private Enderly enderly;

     Retiring( Enderly e){
       this.enderly=e;
     }

     public getBenefits(){
         enderly.getMoney();
     }