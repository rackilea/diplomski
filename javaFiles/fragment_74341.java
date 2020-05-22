String content5 = 
    "<scl>this is scl</scl>\n" +
    "<blah>this isn't</blah>\n" +
    "<scl>this is scl</scl>\n" +
    "<blah>this isn't</blah>\n";
System.out.println(content5.replaceAll("(?:<scl>)(?:.*?)(?:</scl>)", "<credit>$0</credit>" ));