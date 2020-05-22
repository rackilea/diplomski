@DatabaseTable(tableName = "MyTrips")
public class MyTripTable {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private long timestamp;

//    @DatabaseField(foreignAutoRefresh = true)
    @ForeignCollectionField(eager = false)
    private ForeignCollection<PortTable> mPorts;

    public MyTripTable() {
    }

    public ForeignCollection<PortTable> getPorts() {
        return mPorts;
    }

    public long getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}