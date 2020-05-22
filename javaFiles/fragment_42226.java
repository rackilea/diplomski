Public Class Test {

     //g can only be accessed within this class
     //however you can access g with the following getter method
     private double g;

     public static void setG() {

          this.g = 9.5;
     }

     public static void setGWithInput(Double input) {

          this.g = input;              
     }

     public static void printG() {

          //you can access the value of g anywhere from your class
          System.out.println("Value of g is" + this.g);
     }

     //create a public getter to access the value of g form outside the class
     public double getG() {

          return this.g;
     }
}