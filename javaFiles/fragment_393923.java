import static java.lang.Math.sqrt;
import static java.lang.Math.round;


public class Number {

    public int num = 0;

    public void prinTest() {

        System.out.println(this.num);
        System.out.println(this.getSqrt(this.num));
        System.out.println(this.getCheckTri());
    }

    private double getSqrt(double value) {
        return sqrt(value);
    }

    public boolean isSqr() {
        if (this.getSqrt(this.num) == round(this.getSqrt(this.num))) {
            return true;
        } else {
            return false;
        }
    }

    private double getCheckTri() {

        return 8 * this.num + 1;
    }

    public boolean isTriangular() {

        if (this.getSqrt(this.getCheckTri()) * this.getSqrt(this.getCheckTri()) == this.getCheckTri()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Number number = new Number();

        number.num = 49;
        number.prinTest();
        System.out.println(number.isSqr());
        System.out.println(number.isTriangular());

    }
}