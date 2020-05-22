@Override
protected ArrayList<Information> doInBackground(String... params) {

    String jsonStr = makeServiceCall();
    ArrayList<Information> s = new ArrayList<Information>();
    try {
        JSONArray jsonArray=new JSONArray(jsonStr);
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            String id=jsonObject.getString("id");
            String name=jsonObject.getString("label");
            String email=jsonObject.getString("email");
            Information information=new Information(id,name,email);
            s.add(information); 
        }
        System.out.println(jsonStr);
        return s;
    } catch (JSONException e) {
        e.printStackTrace();
    }

    return null;
}