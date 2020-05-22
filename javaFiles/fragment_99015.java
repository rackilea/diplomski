private ArrayList<Usuarios> items;
//private Set<Usuarios> set;
//private ArrayList<Usuarios> newList;

//...

protected Void doInBackground(Void...params) {
    HashMap<String,String> params2 = new HashMap<>();
    params2.put(Config.TAG_PESO,lastpeso2);
    RequestHandler rh = new RequestHandler();
    String s = rh.sendPostRequest(Config.URL_GET_ALL3, params2);
    JSON_STRING = s;
    JSONObject jsonObject = null;
    try {
        if(isLoadMore){
        isLoadMore = false; }
        jsonObject = new JSONObject(JSON_STRING);
        JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

        //make a temporary copy
        Set<Usuarios> set = new HashSet<>(items);

        for (int i = 0; i < result.length(); i++) {
            JSONObject jo = result.getJSONObject(i);
            String id = String.valueOf(jo.getInt(Config.TAG_ID));
            String nombre = jo.getString(Config.TAG_NOMBRE);
            String email = jo.getString(Config.TAG_EMAIL);
            String foto = jo.getString(Config.TAG_FOTO);
            String peso = jo.getString(Config.TAG_PESO);
            String vasos = jo.getString(Config.TAG_VASOS);
            String seguimiento = jo.getString(Config.TAG_SEGUIMIENTO);
            String aplausos = jo.getString(Config.TAG_APLAUSOS);
            String followers = jo.getString(Config.TAG_FOLLOWERS);

            Usuarios user = new Usuarios(id, nombre, email, foto, peso, vasos, seguimiento ,aplausos, followers);
            //items.add(user); //this would be the original, who give me duplicated items

            //newList.add(user);//this is the second arraylist

            set.add(user);
        }

        //clear the list, so no duplicates occurr
        list.clear();
        //copy the temporary set to the items
        list.addAll(set);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return null;
}