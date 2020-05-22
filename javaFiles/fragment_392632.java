HashMap map = new HashMap();
    map.put("PTE", "");
    map.put("LTD", "");
    map.put("PRIVATE", "");
    map.put("LIMITED", "");



    String company = "Basit LTD PRIVATE PTE";


    String words[] = company.split(" ");

    String resultantStr = "";

    for(int k = 0; k < words.length; k++){
        if(map.get(words[k]) == null) {
            resultantStr += words[k] + " ";

        }
    }


    resultantStr = resultantStr.trim();
    System.out.println(" Trimmed String: "+  resultantStr);