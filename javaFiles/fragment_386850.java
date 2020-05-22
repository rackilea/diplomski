Pattern p = Pattern.compile("<p pnum=([0-9]+)>.*?</p>", Pattern.DOTALL);
    Matcher m = p.matcher(text);
    while(m.find()) {
        System.out.format("******Paragraph %s*****%n", m.group(1));
        System.out.println(m.group(0));
    }