String mainStr = "ABBCCCBBAA";

    Pattern p = Pattern.compile("(AA)|(BB)|(BA)|(AB)|(CC)|(BC)");
    Matcher m = p.matcher(mainStr);

    while (m.find()) {
        String matchedStr = m.group(0);

        if("AA".equals(matchedStr) || "BB".equals(matchedStr)){
            mainStr = mainStr.replaceFirst(matchedStr,"X");
        }

        else if("BA".equals(matchedStr) || "AB".equals(matchedStr)){
            mainStr = mainStr.replaceFirst(matchedStr,"Y");
        }
        else if("CC".equals(matchedStr) || "BC".equals(matchedStr)){
            mainStr = mainStr.replaceFirst(matchedStr,"Z");
        }
    }
    mainStr = mainStr.replaceAll("X","A").replaceAll("Y","CC").replaceAll("Z","B");
    System.out.println(mainStr);