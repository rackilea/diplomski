public class City2 implements Comparable<City2> {

    private int zipCode;
    private String cityName;

    public City2(int zipCode, String cityName) {
        this.zipCode = zipCode;
        this.cityName = cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void addAndPrint() {

    }

    @Override
    public int compareTo(City2 city) {
        return this.getZipCode() - city.getZipCode();
    }

}