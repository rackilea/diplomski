public class JsonData {

    @SerializedName("3h")
    private int h3;

    private String name;

    public JsonData(int h3, String name) {
        this.h3 = h3;
        this.name = name;
    }

}