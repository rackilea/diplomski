String s="          Hello World                    ";
    Pattern trimmer = Pattern.compile("^\\s+|\\s+$");
    Matcher m = trimmer.matcher(s);
    StringBuffer out = new StringBuffer();
    while(m.find())
        m.appendReplacement(out, "");
    m.appendTail(out);
    System.out.println(out+"!");