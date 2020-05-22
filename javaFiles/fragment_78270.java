public class Test{

  public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int choice;

       do{
         choice = sc.nextInt();
         switch(choice){

           case 1: function1();
                   break;
           case 2: function2();
                   break;
           case 3: function3();
                   break;
           case 4: function4();
                   break;

          }

        }while(choice!=0);
   }

public static void function1(){/*definition*/}
public static void function2(){/*definition*/}
public static void function3(){/*definition*/}
public static void function4(){/*definition*/}

}