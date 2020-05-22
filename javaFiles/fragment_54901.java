Pattern p1 = Pattern.compile("(<a>.*</a>)");
    Pattern p2 = Pattern.compile("<b>\\d*</b>");
    Matcher m1 = m1 = p1.matcher("<a> kljsdlk <b>123</b> df <b>345</b> sdfklj</a>");
    if (m1.find()) {
      Matcher m2 = p2.matcher(m1.group());
      while (m2.find()) {
        System.out.println(m2.group());
      }
    }