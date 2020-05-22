String str = "text text\n" +
    "blabla HYPERLINK \"mailto:x@x.com\"x@x.com\n" +
    "text text";

str = str.replaceAll("HYPERLINK \\\"mailto:(.*?)\\\"\\1", "<a href=\"$1\">$1</a>");     
System.out.println(str);