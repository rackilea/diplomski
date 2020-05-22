ArrayList<HashMap<String, String>> contactList=new ArrayList<HashMap<String, String>>();
 for(int i=0; i < jsonArray.length(); i++){
 JSONObject jsonObject = jsonArray.getJSONObject(i);
 HashMap<String,String> contact = new HashMap<String,String>();
 contact.put(TAG_ID, jsonObject.optString("id").toString());
 contact.put(TAG_NAME,jsonObject.optString("name").toString());
 contact.put(TAG_EXT,jsonObject.optString("extension").toString());
 contactList.add(contact);
}`