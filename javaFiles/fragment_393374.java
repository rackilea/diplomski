Object nvl(Object value, Object defaultValue) {
  return value != null ? value : defaultValue;
}
<...>
String value = nvl(map.get("Name"), ""); // using empty string instead of null
writer.write(value);