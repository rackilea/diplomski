private static final Gson GSON = ...;

public static class MyJsonData {
  private final ParamThatINeed paramThatINeed;

  public ParamThatINeed getParamThatINeed() { ... }
}

public static class ParamThatINeed {
  ...
}

public static ParamThatINeed extractParamThatINeed(String json) {
  return GSON.fromJson(json, MyJsonData.class).getParamThatINeed();
}