public class Foo {

    private Integer downloads;

    @JsonProperty("re_downloads")
    private Integer reDownloads;

    private Integer updates;

    private Integer returns;

    @JsonProperty("net_downloads")
    private Integer netDownloads;

    private Integer promos;

    private String revenue;

    @JsonProperty("returns_amount")
    private String returnsAmount;

    @JsonProperty("edu_downloads")
    private Integer eduDownloads;

    private Integer gifts;

    @JsonProperty("gift_redemptions")
    private Integer giftRedemptions;

    // Default constructor, getters and setters omitted
}