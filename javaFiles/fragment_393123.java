String text = "<ol start=\"3\">\n\t<li>Element 1</li>\n\t<li>Element 2</li>\n\t<li>Element 3</li>\n</ol>";

String result = Pattern
        .compile("<ol start=\"(\\d)\">")
        .matcher(text)
        .replaceAll(m -> "<ol>" + repeat("\n\t<li style=\"visibility:hidden\" />", 
                                         Integer.parseInt(m.group(1))-1));