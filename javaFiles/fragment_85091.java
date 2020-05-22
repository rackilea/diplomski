package stackJavaExample;
public class Stock {
    private String symbol;
    private String name;
    private double value;
    public Stock(String symbol, String name, double value) {
        this.symbol = symbol;
        this.name = name;
        this.value = value;
    }
    public String getSymbol() { return symbol;}
    public String getName() { return name;}
    public double getValue() {return value;}
}