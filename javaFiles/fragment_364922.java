Pattern p = Pattern.compile("class (\\w+) extends TestCase");
    Matcher m = p.matcher(javaSourceCode);

    String className = "";
    if (m.find()) {
        className = m.group(1);
    }

    String out =  javaSourceCode.replaceFirst("public "+className+"\\s*\\(String name\\)\\s*\\n*\\{[\\w\\W]*?\\}", "");

    System.out.println(out);