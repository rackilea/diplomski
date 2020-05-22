String s = "abc$[A]$def$[B]$ghi";
    Pattern p = Pattern.compile("\\$\\[.*?\\]\\$");
    Matcher m = p.matcher(s);
    while(m.find()){
        String b =  m.group();
        System.out.println(">> " +b.substring(2, b.length()-2));
    }