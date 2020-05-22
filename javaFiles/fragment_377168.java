@DatabaseTable(tableName = "Ports")
public class PortTable {

    /** The id. */
    @DatabaseField(generatedId = true)
    private long id;

    /** The timestamp. */
    @DatabaseField
    private long timestamp;

    /** The my trip table. */
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private MyTripTable myTripTable;

    /**
     * Instantiates a new port table.
     */
    public PortTable() {
    }

    /**
     * Sets the trip assigned.
     *
     * @param myTripTable the new trip assigned
     */
    public void setTripAssigned(MyTripTable myTripTable) {
        this.myTripTable = myTripTable;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the timestamp.
     *
     * @param timestamp the new timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}