import java.util.Scanner;
class Polynomial
{       
    double[] cofficients;
    public Polynomial(Scanner sc)
    {           
        readpoly(sc);
    }
    public void readpoly(Scanner sc)
    {
       if(sc==null)
          return;
       System.out.println("Please enter the higest rank of your polynom");
       int rank = sc.nextInt();
       cofficients=new double[rank+1];
       for(int i = 0 ; i < rank+1  ; i++ ) 
       {
           System.out.println("Please enter the coefficient of x^" + i);
           cofficients[i]=sc.nextDouble();
       }
    }
}