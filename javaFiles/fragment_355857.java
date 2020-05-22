public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    Type thingsType = new TypeToken<List<Vulume>>() {}.getType();
    List<Vulume> things = gson.fromJson(new FileReader("input.json"), thingsType);
    System.out.println(gson.toJson(things));
  }
}

class Vulume
{
  String id;
  String name;
  String status;
  List<Vulume> vulumes;
}