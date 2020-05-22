public class FieldToMessageMapper {

    private static final Map<String, Function<String, String>> WORKINGTYPE_MESSAGE_MAPPER = new HashMap<>();
    static {
      WORKINGTYPE_MESSAGE_MAPPER.put("abc", fieldArray1 -> rightPad("a", Integer.parseInt(fieldArray1)));
      WORKINGTYPE_MESSAGE_MAPPER.put("def", fieldArray1 -> rightPad("d", Integer.parseInt(fieldArray1)));
      WORKINGTYPE_MESSAGE_MAPPER.put("DEFAULT", fieldArray1 -> rightPad("g", Integer.parseInt(fieldArray1)));
    }

    private static Map<String, BiFunction<MyObject, String, String>> MESSAGE_MAPPER = new HashMap<>();
    static {
      MESSAGE_MAPPER.put(Constants.WORKFLOW, (o, fieldArray1) -> rightPad(o.getFieldOne(), Integer.parseInt(fieldArray1)));
      MESSAGE_MAPPER.put(Constants.WORKVOLUME, (o, fieldArray1) -> rightPad(o.getFieldTwo(), Integer.parseInt(fieldArray1)));
      MESSAGE_MAPPER.put(Constants.WORKTYPE,
        (o, fieldArray1) -> WORKINGTYPE_MESSAGE_MAPPER.getOrDefault(o.getFieldThree().toLowerCase(), WORKINGTYPE_MESSAGE_MAPPER.get("DEFAULT")).apply(fieldArray1));
    }

    public static Optional<String> map(MyObject o, String fieldArray0, String fieldArray1) {
      return Optional.ofNullable(MESSAGE_MAPPER.get(fieldArray0.toLowerCase()))
        .map(mapper -> mapper.apply(o, fieldArray1));
    }

    private static String rightPad(String string, int pad) {
        // TODO right pad
        return string;
    }
  }