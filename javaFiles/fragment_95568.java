//returned value in radians
static double evaluateSinxPlusx(double y){

    double delta = y>0 ?  0.01 : -0.01 ;//change constants
    double epsilon = 0.01;            //to change
    int iterations = 100;             //accuracy

    double x = 0;
    double sum = 1;

    while(Math.abs(y - sum) > epsilon) {
        x+=delta;
        //based Taylor series approximation
        double term = 1.0;
        sum  = x;
        double d = 1;
        for (int i = 1; i< iterations; i++) {
             term = Math.pow(x, i);
             d*=i;
             if (i % 4 == 1) {

                sum += term/d;
            }
             if (i % 4 == 3) {
                sum -= term/d;
            }
         }
    }
    return x;
}

//test it 
public static void main(String[] args) throws Exception{

    double y = 0.979;
    //expected x = 0.5 radians
    System.out.println("for x="+ evaluateSinxPlusx(y)+"(radians), sin(x)+x = "+ y);

    y = -0.979;
    //expected x = - 0.5 radians
    System.out.println("for x="+ evaluateSinxPlusx(y)+"(radians), sin(x)+x = "+ y);

    y = 0.33256;
    //expected x = 0.16666 radians
    System.out.println("for x="+ evaluateSinxPlusx(y)+"(radians), sin(x)+x = "+ y);
}