public class Car1 extends Vehicle{

    String regnr;

    public Car1(String regnr) {
        super();//pass data to parent constructor if needed
        this.regnr = regnr;
    }

    public String getRegNbr() {
        return regnr;
    }

}