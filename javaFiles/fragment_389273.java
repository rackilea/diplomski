public class CustomCeiling {

    public static double getCeiling(double number){
        return Math.round(number/10)*10;
    }

    public static void main(String args[]){
        System.out.println(getCeiling(2));
        System.out.println(getCeiling(4));
        System.out.println(getCeiling(5));
        System.out.println(getCeiling(10));
    }
}