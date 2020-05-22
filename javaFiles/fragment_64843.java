String in = "a\\tb\\n\\\"c\\\"";

System.out.println(in);
//This prints
// a\tb\n\"c\"

String out = StringEscapeUtils.unescapeJava(in);

System.out.println(out);
//This prints
// a    b
// "c"