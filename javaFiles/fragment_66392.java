String param = "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\",\"\\\\\\\"\"]";
System.out.println(param);
// => ["\n","\t","'","\"","\\","\\\""]
String regex = "(?s)(?<!\\\\)((?:\\\\{2})*)\"([^\"\\\\]*(?:\\\\.[^\"\\\\]*)*)\"";
param = param.replaceAll(regex, "$1$2");
System.out.println(param);
// => [\n,\t,',\",\\,\\\"]