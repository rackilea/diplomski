String[][] abriev = {{"United Kingdom", "kilometers"}, {"UK", "km"}};

    String origText = "The;coastline;of;United Kingdom;is;12429;kilometers";
    HashMap<String, String> wordAbbr = new HashMap<String,String>();
    for(int i = 0; i < abriev[0].length; i++ )
    {
        wordAbbr.put(abriev[0][i], abriev[1][i]);
    }
    String [] origArr = origText.split(";");
    String output = "";
    for(String s : origArr){
        if(wordAbbr.get(s)!=null) {
            output = output + " " + wordAbbr.get(s);
        }else {
            output = output + " " + s;
        }
    }
    output = output + ".";

    System.out.println(output);