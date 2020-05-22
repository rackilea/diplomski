String str = "This whole quote @@  is one big String -- asdf @@\n" +
             "-- I don't want to replace this @@\n" + 
             "But I want to replace this @@!";
str = str.replaceAll("(?m)^(((?!--).)*?)@@", "$1");

System.out.println(str);