String[] string = new String[] { "<yy2yy>2</yy2yy>", "<yy3yy>3</yy3yy>",
            "<yyhhhhyy>50</yyyyy>", "<yyyyy>123</yyyyy>" };

    for (String s : string) {
        System.out.println(s.replaceAll("<[^>]+>", ""));
    }