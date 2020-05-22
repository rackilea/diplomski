public void RestoreData()
{
   try{
    String toConvert = "[{...}]" // I don't place full String, but it's typical JSONArray, but in String
    ArrayList<MyClass> listdata = new ArrayList<MyClass>();
    JSONArray jsonArray = new JSONArray(toConvert); 

    if (jsonArray != null) {
       Gson gson = new Gson();
        for (int i=0;i<jsonArray.length();i++){
            String json = jsonArray.getJSONObject(i).toString();
            MyClass obj = gson.fromJson(json, MyClass.class);
            listdata.add(obj);
        }
    }
    }catch(JSONException e){
          e.printStackTrace();
    }
}