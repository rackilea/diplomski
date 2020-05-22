String[] tokens = "{\"comp1.a\":1,comp1.b\":\"2\",\"comp1.c.aa\":3,\"comp1.c.bb\":\"4\"}".replaceAll("\\{|\\}", "").split(",");

Map graph = new HashMap();
for (String token : tokens)
{
  parse(graph, token);
}

StringBuilder jsonBuilder = new StringBuilder();
toJson(jsonBuilder, graph);

System.out.println(jsonBuilder.toString());