public class JsonParse
 {
    public static void main(String... args)
    {
        Employee product = new Employee("JSON");
        Gson gson = new GsonBuilder().create(); 
        gson = new 
        GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String result = gson.toJson(product);
        System.out.println(result);
    }
 }

class Employee
{

  @Expose
  private byte [] name;

  public Employee(String name)
  {
     this.name = name.getBytes();
  }

}