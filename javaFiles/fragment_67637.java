public class TestPolynomials {

    public static void main(String[] args) {
        Element[] polynomialList = { new Element(5,"x",2), new Element(1,"y",3), new Element(6,"1",0) };

        printPolynomials(polynomialList);

    }

    public static void printPolynomials( Element[] pList ) {
        for( int i = 0; i < pList.length; i++ ) {
            System.out.printf("%2.1f*%s*%d, ", pList[i].getCoefficient(), pList[i].getVariable(), pList[i].getExponent() );
        }
    }

}