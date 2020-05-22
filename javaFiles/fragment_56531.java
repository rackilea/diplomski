String parseLine = "p:55 - AutoRefreshStoreCategories  Data:Previous    UserLogged:true    Attribute:1    Attribute:16      Attribute:2060";
    Matcher m = Pattern
            .compile(
                    "p:(\\d+)\\s-\\s(.*?)\\s+Data:(.*?)\\s+UserLogged:(.*?)\\s+Attribute:(\\d+)\\s+Attribute:(\\d+)\\s+Attribute:(\\d+)")
            .matcher(parseLine);
    if(m.find()) {
        int p = Integer.parseInt(m.group(1));
        String method = m.group(2);
        String data = m.group(3);
        boolean userLogged = Boolean.valueOf(m.group(4));
        int at1 = Integer.parseInt(m.group(5));
        int at2 = Integer.parseInt(m.group(6));
        int at3 = Integer.parseInt(m.group(7));
        System.out.println(p + " " + method + " " + data + " " + userLogged + " " + at1 + " " + at2 + " "
                + at3);
    }