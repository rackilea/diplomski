public class EmptyStringAsEmptyWarningConditionlTypeAdapter extends TypeAdapter<WARNING_CONDITION_LIST> {

  @Override
  public void write(JsonWriter out, WARNING_CONDITION_LIST value) throws IOException {
    out.beginObject();
    out.name("warningConditionList");
    out.value(value.warningConditionList.warningCondition);
    out.endObject();
  }

  @Override
  public WARNING_CONDITION_LIST read(JsonReader in) throws IOException {
    WARNING_CONDITION_LIST result = new WARNING_CONDITION_LIST();
    result.warningConditionList =  new WarningConditionList();
    result.warningConditionList.warningCondition = "";

    if (in.peek() == JsonToken.BEGIN_OBJECT) {
        in.beginObject();
        in.nextName();
        in.beginObject();
        in.nextName();
        result.warningConditionList.warningCondition = in.nextString();
        in.endObject();
        in.endObject();
    } else {
        in.nextString();
        return null;
    }
    return result;
  }
}