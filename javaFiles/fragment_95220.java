String content = "Hello world, visit this link: www.stackoverflow.com";

    String[] splitted = content.split(" ");
    for (int i = 0; i < splitted.length; i++) {
        if ((splitted[i]).contains("www.")) { // use more statements for
                                                // http:// etc..
            System.out.println(splitted[i]); //just checking the output
            String link = "<a href=\"" + splitted[i] + "\">" + splitted[i] + "</a>";

            System.out.println(link); //just checking the output
        }
    }