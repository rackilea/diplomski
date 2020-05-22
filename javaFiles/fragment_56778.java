public final static Map<String, Type> VAR;

  private static Type listOfIntegerType()
  {
      @SuppressWarnings("serial")
      TypeToken<List<Integer>> t = new TypeToken<List<Integer>>(){};
      return t.getType();
  }

  static {
      VAR = new HashMap<>();
      VAR.put("a", listOfIntegerType());
  }