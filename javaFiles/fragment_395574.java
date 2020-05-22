String input = "{\r\n" + 
               "    \"stringList\": [\r\n" + 
               "        \"somethingElse\"\r\n" + 
               "    ],\r\n" + 
               "    \"simpleString\": \"something\"\r\n" + 
               "}";
AClass aClass = new ObjectMapper().readValue(input, AClass.class);
System.out.println("justAString = " + aClass.getJustAString());
System.out.println("someString = " + aClass.getSomeString());