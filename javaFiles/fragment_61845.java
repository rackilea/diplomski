public class Book {
    private int series;
    private String name;
    private int intA;
    private int intB;

    public Book(int series,String name, int intA, int intB) {
        this.series = series;
        this.name = name;
        this.intA = intA;
        this.intB = intB;
    }
    ....
    .... (add other methods as needed, you will definitely need a 
           toString() method, and getIntA(), getIntB(), getSeriesNum(),
           getName() etc.)
}