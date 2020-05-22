RequestParams params = new RequestParams();
JSONArray arrayName = new JSONArray();
JSONArray arrayContact = new JSONArray();

for(i = 0;i < contacts.size();i++ ) {
    arrayName.put(contacts.get(i).getName());
    arrayContact.put(contacts.get(i).getContact());    
}
params.put("ContactNameArray",arrayName);
params.put("ContactNumberArray",arrayContact);