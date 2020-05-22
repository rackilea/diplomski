ObjectMapper objectMapper = new ObjectMapper();
JavaObject javaObject = objectMapper.readValue("{\n" + 
        "  \"time\":{\n" + 
        "    \"date\":{\n" + 
        "      \"year\":2017,\n" + 
        "      \"month\":3,\n" + 
        "      \"day\":12\n" + 
        "     },\n" + 
        "    \"time\":{\n" + 
        "      \"hour\":10,\n" + 
        "      \"minute\":42,\n" + 
        "      \"second\":42,\n" + 
        "      \"nano\":810000000\n" + 
        "     }\n" + 
        "   },\n" + 
        "\"name\":\"Jon\"}", JavaObject.class);
System.out.println(javaObject);