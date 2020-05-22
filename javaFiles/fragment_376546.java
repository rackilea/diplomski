public class ResponseService
{
  public static void main(String[] args)
  {
    final String OPENING_CURLY = "{";
    final String CLOSING_CURLY = "}";
    final String COLON = ",";
    final String QUOTE = "\"";

    String jsonData; // Load you response json feed.
    List<Object> ids = JsonPath.read(jsonData, "$.response.data[*].id");
    StringBuilder formattedIds = new StringBuilder(OPENING_CURLY);
    for (Iterator it = ids.iterator(); it.hasNext();)
    {
      formattedIds.append(it.next());
      if (it.hasNext())
      {
        formattedIds.append(COLON);
      }
    }
    formattedIds.append(CLOSING_CURLY);
    System.out.println(formattedIds);

    List<Object> names = JsonPath.read(jsonData, "$.response.data[*].name");
    StringBuilder formattedNames = new StringBuilder(OPENING_CURLY);
    for (Iterator it = names.iterator(); it.hasNext();)
    {
      formattedNames.append(QUOTE)
        .append(it.next())
        .append(QUOTE);
      if (it.hasNext())
      {
        formattedNames.append(COLON);
      }
    }
    formattedNames.append(CLOSING_CURLY);
    System.out.println(formattedNames);
  }
}