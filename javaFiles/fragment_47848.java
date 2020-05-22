public class outer{

                int x = 10;


               class inner{

                 int x=5;

                 public void go(){

   System.out.println("Inner x: "+ this.x);           // Prints x in Inner class
   System.out.println("Inner x: "+ Outer.this.x);     // Prints x in Outer class


                }
           }
       }