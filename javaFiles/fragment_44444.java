String s = "{\\af31507 \\ltrch\\fcs0 \\insrsid6361256 Study Title: {Test for 14431 process\\'27s \\u8805 1000 Testing2 14432 \\u8805 8000}}{\\rtlch\\fcs1 \\af31507 \\ltrch\\fcs0 \\insrsid12283827";
    Pattern p = Pattern.compile("(?<=Study Title: \\{)[^}]*(?=\\})");
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group());
    }

Test for 14431 process\'27s \u8805 1000 Testing2 14432 \u8805 8000