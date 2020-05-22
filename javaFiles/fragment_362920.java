public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            popup pop = new popup();
            System.out.println("" + i);
            pop.show();
            while (pop.isDisplayed()) {
                // waiting
                Thread.sleep(1000);   // you could remove this as well
            }
        }
    }
}