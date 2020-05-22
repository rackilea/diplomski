public class JsonPathReader
{
  public static void main(String[] args) throws IOException
  {   
    InputStream jsonData; // Load you response json feed.
    List<Integer> segmentIds = JsonPath.read(jsonData, "$.response.data[*].segment_id");
    System.out.println(segmentIds);
  }
}