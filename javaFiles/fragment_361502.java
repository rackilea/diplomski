String script = "(function() {\n" +
  "  var ArrayList = Java.type('java.util.ArrayList')\n" +
  "  var ArrayListExtender = Java.extend(ArrayList)\n" +
  "  var list = new ArrayListExtender() {\n" +
  "    get: function(idx) {\n" +
  "      return idx >= list.size() ? " +
  "'no such value' : Java.super(list).get(idx);\n" +
  "    }\n" +
  "  }\n" +
  "  return list;\n" +
  "} ());";

  ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
  @SuppressWarnings("unchecked")
  List<String> result = (List<String>) engine.eval(script);
  result.add("gotcha");
  System.out.println(result.get(0));
  System.out.println(result.get(10));