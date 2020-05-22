private void parse(Map graph, String token)
{
  int index = token.indexOf(".");

  if (index > -1)
  {
    String name = token.substring(0, index).replaceAll("\"", "");
    String remainder = token.substring(index + 1, token.length());

    Map children = (Map)graph.get(name);
    if (children == null)
    {
      children = new HashMap();
      graph.put(name, children);
    }

    parse(children, remainder);
  }
  else
  {
    String[] nameValuePair = token.split(":");
    graph.put(nameValuePair[0].replaceAll("\"", ""), nameValuePair[1]);
  }
}