String cab ="<CabList><status>0</status><cab>AP09BS9127</cab><cab>AP09BS9126</cab></CabList>";
    Pattern p = Pattern.compile("<status>([^<]+)</status>((<cab>([^<]+)</cab>)*)");
    Matcher m = p.matcher(cab);
    if(m.find()) {
        System.out.println("Status: " + m.group(1));
        List<String> cablist = Arrays.asList(m.group(2).replace("<cab>", "").replace("</cab>", "#").split("#"));
        System.out.println("Cab: " + cablist);          
    }