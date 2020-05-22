private void toJson(StringBuilder jsonBuilder, Map graph)
{
  jsonBuilder.append("{");

  for (Object key : graph.keySet())
  {
    jsonBuilder.append("\"").append(key).append("\"");

    Object value = graph.get(key);

    if (value instanceof Map)
    {
      toJson(jsonBuilder.append(":"), (Map)value);
      jsonBuilder.append("}");
    }
    else
    {
      jsonBuilder.append(":").append(value).append(",");
    }
  }

  jsonBuilder.replace(jsonBuilder.length() - 1, jsonBuilder.length(), "}");
}