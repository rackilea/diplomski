/*first file*/
    String jsonData = readFile("C:\\Users\\kbelkhiria\\Desktop\\Karim_JSON\\alt.json");
    JSONArray jarr =  new JSONArray(jsonData);

    /*array of first file's ids*/
    ArrayList<String> srcArray = new ArrayList<>();

    for(int i = 0; i < jarr.length(); i++) {
        srcArray.add(jarr.getJSONObject(i).getString("pId"));
    }

    /*second file*/

    // second form in a seperate file
    JSONObject obj = new JSONObject(readFile("C:\\Users\\kbelkhiria\\Desktop\\Karim_JSON\\alt2.json"));
    JSONArray arr = obj.getJSONArray("pList");

    /*array of second file's ids*/
    ArrayList<String> dstArray = new ArrayList<>();

    for(int i = 0; i < arr.length(); i++) {
        dstArray.add(jarr.getJSONObject(i).getString("pId"));
    }

    for (String string : srcArray) {
        if (dstArray.indexOf(string)==-1)
            System.out.println(string + " is missing in the second file");
    }