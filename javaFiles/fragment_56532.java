String parseLine = "p:55 - AutoRefreshStoreCategories  Data:Previous    UserLogged:true    "
            + "Attribute:1    Attribute:16      Attribute:2060";
    Matcher m = Pattern.compile("p:(\\d+)\\s-\\s(.*?)\\s+Data:(.*?)\\s+UserLogged:(.*?)").matcher(
            parseLine);
    if(m.find()) {
        for(int i = 0; i < m.groupCount(); ++i) {
            System.out.println(m.group(i + 1));
        }
    }

    Matcher m2 = Pattern.compile("Attribute:(\\d+)").matcher(parseLine);
    while(m2.find()) {
        System.out.println("Attribute matched: " + m2.group(1));
    }