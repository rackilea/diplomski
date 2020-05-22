public static void main(String[] args) throws InterruptedException {


         System.out.println(power(2,2.5));

    }


  public static double power(double x, double y) {

    double val = y *  Math.log(x);

    double result = Math.exp(val);

            return result;
    }