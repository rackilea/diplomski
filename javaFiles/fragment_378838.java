@JsonFilter("dataFilter")
public class SimpleData {

    @JsonProperty("name")
    String firstName;

    @JsonProperty("secondName")
    String lastName;

    @JsonProperty("country")
    String country;

    @JsonProperty("region")
    String region;

    @JsonProperty("city")
    String city;

    @JsonProperty("genre")
    String genre;

    public SimpleData() {

        this.firstName = "Bryan";
        this.lastName = "Adams";

        this.country = "Canada";
        this.region = "Ontario";
        this.city = "Kingston";
        this.genre = "Rock";

    }

    public String getFirstName() {    return firstName;       }
    public void setFirstName(String firstName) {  this.firstName = firstName;  }
    public String getLastName() {   return lastName;    }
    public void setLastName(String lastName) {  this.lastName = lastName;       }
    public String getCountry() {    return country;    }
    public void setCountry(String country) {  this.country = country;      }
    public String getRegion() {   return region;     }
    public void setRegion(String region) {   this.region = region;       }
    public String getCity() {  return city;     }
    public void setCity(String city) {   this.city = city;     }
    public String getGenre() {   return genre;      }
    public void setGenre(String genre) {    this.genre = genre;     }
}