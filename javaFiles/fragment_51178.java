JSONObject jsonobj = new JSONObject(str);
JSONArray foodArray = jsonobj.getJSONObject("report").getJSONArray("foods");
for(int i = 0;i<foodArray.length();i++){
    JSONArray nutrientsArray = foodArray.getJSONObject(i).getJSONArray("nutrients");
    for(int j = 0;j<nutrientsArray.length();j++){
        JSONObject nutrientObj = nutrientsArray.getJSONObject(j);
        if(nutrientObj.has("gm")){
            System.out.println("do what you want in case it has gm");
            //do what you want in case it has gm
        }else{
            //do what you want in case it do not have gm
            System.out.println("do what you want in case it not gm");
        }
    }
}