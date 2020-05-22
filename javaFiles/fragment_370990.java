public class FlurryAppMetric {
    @SerializedName("@metric");
    private String metric;

    @SerializedName("@startDate");
    private String startDate;

    @SerializedName("@endDate");
    private String endDate;

    @SerializedName("@generatedDate");
    private String generatedDate;

    @SerializedName("@versionDate");
    private String version;

    @SerializedName("day");
    private ArrayList<FlurryMetric> day;
}

public class FlurryMetric {
    @SerializedName("@date");
    private String date;

    @SerializedName("@value");
    private String value;
}