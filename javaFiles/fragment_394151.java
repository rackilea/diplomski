enum KeyCode {

  A(23),
  ...;

  private int code;

  private static final Map<Integer, KeyCode> keys = new HashMap<Integer, KeyCode>();

  static {
    for(KeyCode code : values()) {
        keys.put(code.code, code);
    }
  }

  private KeyCode(int code) {
    this.code = code;
  }

  public static KeyCode getKey(int code) {
   return keys.get(code);
  }

}