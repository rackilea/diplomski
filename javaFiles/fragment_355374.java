public class PriceList{

    private Map<String, Double> map = new HashMap<String, Double>();

    private static PriceList instance = null;

    private PriceList() {}

    public static PriceList getInstance() {
        if (instance == null)
            instance = new PriceList();
        return instance;
    }

    public void put(String string, double d) {
        map.put(string,double);       
    }
}