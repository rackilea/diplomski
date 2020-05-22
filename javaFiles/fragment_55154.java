String str = 
    "text text\n" +
    "blabla (mailto:x@x.com)[this email] or (mailto:x@y.com)[x@y.com]\n" +
    "text (http://www.google.com/)[this is google] text";

str = str.replaceAll("\\((.*?)\\)\\[(.*?)\\]", "<a href=\"$1\">$2</a>");       
System.out.println(str);