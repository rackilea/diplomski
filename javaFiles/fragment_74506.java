public class Response{

@SerializedName("rows")
@Expose
private List<Row> rows = null;
@SerializedName("pin_type_text")
@Expose
private JsonElement pinTypeText;

public List<Row> getRows() {
return rows;
}

public void setRows(List<Row> rows) {
this.rows = rows;
}

public JsonElement getPinTypeText() {
return pinTypeText;
}

public void setPinTypeText(JsonElement pinTypeText) {
this.pinTypeText = pinTypeText;
}

}