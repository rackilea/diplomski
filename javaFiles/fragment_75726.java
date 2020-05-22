public class Type {
  private int id;
  private String name;
  ...
}

gson.fromJson(jsonString, Type.class);