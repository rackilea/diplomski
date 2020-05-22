public class MyDistance implements Comparable<MyDistance> {
    private String placename;
    private double mileage;

    public MyDistance(String placename, double milage) {
        this.placename = placename;
        this.milage = milage;
    }

    public String getPlacename() {
        return this.placename;
    }

    public double getMilage() {
        return this.milage;
    }

    @Override
    public int compareTo(MyDistance anotherDistance)
    {
        return milage.compareTo(anotherDistance.getMilage());
    }
}