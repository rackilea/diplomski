@XmlRootElement
public class Country {

    String countryName;
    List<State> states;
    public Country(String countryName, List<State> states) {
        this.countryName = countryName;
        this.states = states;
    }
    public Country() {
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public List<State> getStates() {
        return states;
    }
    public void setStates(List<State> states) {
        this.states = states;
    }

}