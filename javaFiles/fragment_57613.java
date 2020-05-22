public class Response {
    @SerializedName("Message")
    public String Message;

    @SerializedName("Obj")
    public Obj obj;

    @SerializedName("Statue")
    public String Statue;

}

public class Obj {
    @SerializedName("IdCatrgorie")
    int IdCatrgorie;

    @SerializedName("Name")
    String Name;

    @SerializedName("IdUser")
    int IdUser;
}