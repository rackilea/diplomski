public class Function { 

private double coefficient;
private int startX;
private int endX;
private int exponent;


protected Function(double coefficient, int startX, int endX, int exponent) {
    this.coefficient = coefficient;
    this.startX = startX;
    this.endX = endX;
    this.exponent = exponent;

  }  

    public static void main(String[] args) {

    Function func1 = new Function(2, 1, 2, 2); 

    Function func2 = new Function(0,1,2,1/3);

    // now func1 properties are the same as func2
      } 
   }
}