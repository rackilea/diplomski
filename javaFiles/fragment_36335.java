public class MongoOID {

    @SerializedName("$oid")
    private String oid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}

public class MongoId {

    @SerializedName("_id")
    private MongoOID _id;

    /**
     * http://www.baeldung.com/migrating-to-java-8-date-time-api
     */
    private LocalDateTime created;

    /**
     * http://www.baeldung.com/migrating-to-java-8-date-time-api
     */
    private LocalDateTime updated;

    //region Getter and Setter
    public MongoOID get_id() {
        return _id;
    }

    public void set_id(MongoOID _id) {
        this._id = _id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
    //endregion
}