public String clean(String unsafe){
        Whitelist whitelist = Whitelist.none();
        whitelist.addTags(new String[]{"p","br","ul"});

        String safe = Jsoup.clean(unsafe, whitelist);
        return StringEscapeUtils.unescapeXml(safe);
 }