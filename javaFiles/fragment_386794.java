public class Airport_example {

private String airportID;
private String city;
private String code3;
private String country;
private String timezone;

public Airport_example(String airportID, String city, String code3, String country, String timezone) {
    this.airportID = airportID;
    this.city = city;
    this.code3 = code3;
    this.country = country;
    this.timezone = timezone;
    }
}

public String toString() {
    // replace the string you want each object to print out
    return this.airportID + ", " + this.city + ", " + this.code3 + ", " + this.country + ", " + this.timezone;
}