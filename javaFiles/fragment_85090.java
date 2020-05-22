package stackJavaExample;
public class Test {
    public static void main(String[] args) {
        String[] testNames = {"test1","test2","notThere"};
        StockCheck mStockCheck = new StockCheck();

        for (int i=0; i<testNames.length; i++) {
            Stock result = mStockCheck.getStock(testNames[i]);
            if (result == null) {
                System.out.println("No stock for name: " + testNames[i]);
            } else {
                System.out.println("Found stock: " + result.getName() + ", " + result.getSymbol() + ", " + result.getValue());
            }
        }
    }
}