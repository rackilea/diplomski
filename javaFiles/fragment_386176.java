String c= "hjdg$h&jk8^i0ssh6";
        Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
        Matcher match= pt.matcher(c);
        while(match.find())
        {
            String s= match.group();
        c=c.replaceAll("\\"+s, "");
        }
        System.out.println(c);