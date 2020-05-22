JSONObject JSONSend= new JSONObject();
JSONArray ja = null;
JSONArray tmp = new JSONArray();
for(String s[] : Items){
    ja = new JSONArray();
    for(int i = 0; i<s.length; i++)
        ja.put(s[i]);
    tmp.put(ja);
}
JSONSend.put("Items", tmp);