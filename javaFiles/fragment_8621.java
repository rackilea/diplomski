public interface Renderable
{
  public List<String> getHeaders();
  public List<List<String>> getData();
}

public class A implements Renderable
{
  private String name;
  private int age;

  public List<String> getHeaders()
  {
    List<String> headers = new ArrayList<String>();
    headers.add("Name");
    headers.add("Age");
    return list;
  }

  public List<List<String>> getData()
  {
    List<List<String>> data = new ArrayList<List<String>();
    List<String> row = new ArrayList<String>();
    row.add(name);
    row.add(String.valueOf(age));
    data.add(row);
    return data;
  }

  //getters and setters

}