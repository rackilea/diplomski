enum SOEnum {
 ABC("ABC"),
 UV_WX_YZ("UVwxYz");

 private final String value;

 @JsonValue
 public String getValue() {
   return value;
 }
}