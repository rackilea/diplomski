public class SwapTest {

    int firstNum = 10;
    int secondNum = 20;

    public static void main(String args[])
    {
        SwapTest swap2Numbers = new SwapTest();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            swap2Numbers.proceedNoInterimVariable();
        }
        System.out.println(" no temp variable took " + (System.currentTimeMillis()-before));

        before = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            swap2Numbers.proceedWithInterimVariable();
        }
        System.out.println("with temp variable took " + (System.currentTimeMillis()-before));
    }

    private void proceedNoInterimVariable()
    {

        firstNum = firstNum + secondNum;
        secondNum = firstNum - secondNum;
        firstNum = firstNum - secondNum;
    }

    private void proceedWithInterimVariable()
    {
        int temp = firstNum;
        firstNum = secondNum;
        secondNum = temp;
    }

}