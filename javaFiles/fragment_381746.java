String input = 
        "year.\", [229, 338], null, [1144, 2371]\r\n" + 
        "year....\", null, null, [812]\r\n" + 
        "year:, null, null, [1019, 1028, 2463]\r\n" + 
        "year;, null, [164], [1052]";

String expected = 
        "year.\", 229:338, , 1144:2371\r\n" + 
        "year....\", , , 812\r\n" + 
        "year:, , , 1019:1028:2463\r\n" + 
        "year;, , 164, 1052";

input = input.replace("null", "")
             .replaceAll("(?<=\\d), ", ":")
             .replaceAll("\\[|\\]", "");

System.out.println(input.equals(expected));