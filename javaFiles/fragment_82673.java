// composite primary key
public class TripId implements Serializable {
    private int id;
    private long trip_no;

    public TripId(int id, long trip_no) {
        this.id = id;
        this.trip_no = trip_no;
    }

    // getters, setters, hashCode, equals
}