public class ArithmTest {

    public static void main(String[] args) {
        double d1 = (0.040147018)*(-0.9942854)+(0.9984244)*(-0.32688835)+(0.039202508)*(9.343558);
        System.out.println(d1);

        float f1 = 0.040147018f;
        float f2 = -0.9942854f;

        float f3 = 0.9984244f;
        float f4 = -0.32688835f;

        float f5 = 0.039202508f;
        float f6 = 9.343558f;

        System.out.println(f1*f2 + f3*f4 + f5*f6);

    }
}