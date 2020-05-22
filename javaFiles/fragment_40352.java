String text =
        "DEL: line1\n" +
        "KEP: line2\r\n" +
        "DEL: line3\n" +
        "KEP: line4\r" +
        "DEL: line5\r" +
        "DEL: line6\r" +
        "KEP: line7\n" +
        "DEL: line8";
    StringBuffer sb = new StringBuffer(text);
    Pattern delLine = Pattern.compile("(?m)^DEL:.*$");
    String cleanedUp = delLine.matcher(sb).replaceAll("<deleted!>");
    System.out.println(cleanedUp);