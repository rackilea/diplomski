@SuppressWarnings("serial")
@Entity
@Immutable
@Table(name = "T_ADDRESS_INFO")
public class AddressInfo implements java.io.Serializable {


    public class Coordinate {

        double latitude;
        double longitude;

        Coordinate(int latitude, int longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @Column(name = "LATITUDE")
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        @Column(name = "LONGITUDE")
        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    private Long id;
    private String street;
    private String address;
    private String code;
    private String city;
    private String phone;
    private String fax;
    private String email;
    private String website;
    private String info;


    public AddressInfo() {
    }