String test = "List<String> t = new ArrayList<String>();";
System.out.println(test.replaceAll("(?s)new (\\w+)<.+>(\\(.*?\\);)", "new $1<>$2"));

String test2 = "List<String> t = new ArrayList<String>(getList());";
System.out.println(test2.replaceAll("(?s)new (\\w+)<.+>(\\(.*?\\);)", "new $1<>$2"));

String test3 = "List<String> t = new ArrayList<String>(\n\tgetList(\n\t\tanotherMethod()\n\t)\n);";
System.out.println(test3.replaceAll("(?s)new (\\w+)<.+>(\\(.*?\\);)", "new $1<>$2"));

String test4 = "List<String> t = new List<String>(){ /* implementation */ };";
System.out.println(test4.replaceAll("(?s)new (\\w+)<.+>(\\(.*?\\);)", "new $1<>$2"));

String test5 = "List<String> t = new List<String>()\n{\n\t/* implementation */\n};";
System.out.println(test5.replaceAll("(?s)new (\\w+)<.+>(\\(.*?\\);)", "new $1<>$2"));