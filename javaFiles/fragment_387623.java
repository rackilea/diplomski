Pattern p = Pattern.compile("<ol>(.*?)</ol>");
    Matcher m = p.matcher("...");
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
        sb.append("#").append(m.group(1)).append("\n");
    }
    String result = sb.toString();