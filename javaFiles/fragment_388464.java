public class CurrentWeather {

    private List<Weather> weather;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String city;
}

 public class Weather{
        @SerializedName("id")
        private String id;
        @SerializedName("main")
        private String title;
        @SerializedName("description")
        private String description;
    }