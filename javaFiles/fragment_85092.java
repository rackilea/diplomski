package stackJavaExample;
public class StockCheck {
    private Stock[] d;
    public StockCheck() {
        d = new Stock[2];
        d[0] = new Stock("a","test1", 22);
        d[1] = new Stock("b","test2", 34);
    }
    public Stock getStock(String name) {
        for (int i=0; i < d.length; i++) {
            if (d[i].getName().equalsIgnoreCase(name)) {
                return d[i];
            }
        }
        return null;
    }
}