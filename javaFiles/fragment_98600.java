public class ave {
 public static void main(String args[]) {
Average object = new Average(3,4,6);
 }
}


public class Average {
    public Average(double first, double second, double third){
        double ave = (first + second + third)/3;
        System.out.println(ave);
    } 
}