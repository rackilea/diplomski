String s = "+7312xxxx - +7657xxxx";
    Pattern p = Pattern.compile("^([^\\s-]*)\\s*-\\s*(.*)$");
    Matcher m = p.matcher(s);
    while (m.find()) {
      System.out.println(m.group(1));
      System.out.println(m.group(2));
    }