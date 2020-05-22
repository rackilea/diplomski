class Segment {

    @SerializedName(value = "segment_id", alternate = {"Segment_ID"})
    @Expose
    private String segmentID;

    @SerializedName(value = "status", alternate = {"Status"})
    @Expose
    private String status;

    @SerializedName(value = "datetime", alternate = {"DateTime"})
    @Expose
    private String dateTime;

}