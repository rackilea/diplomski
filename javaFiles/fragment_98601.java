public class ave {
 public static void main(String args[]) {
Average object = new Average();
 double Avg = object.takeaverage(3,4,6);
 }
}


public class Average {
public double takeaverage(double first, double second, double third) {
 double ave = (first + second + third)/3;
 System.out.println(ave);
 return ave; } 
}