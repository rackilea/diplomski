//read file        
BufferedReader in = new BufferedReader(new FileReader("path/json.txt"));
String line;
StringBuilder sb = new StringBuilder();
while((line =in.readLine()) != null){
    sb.append(line);
}
in.close();


//create a json object
JSONObject json = new JSONObject(sb.toString());

//pid to search for
String pid = "XXX";

//loop over the items array and look for pid
JSONArray items = json.getJSONArray("items");
for(int i = 0 ; i < items.length(); i++){
    JSONObject item = items.getJSONObject(i);
    String id = item.getString("id");
    if(pid.equals(id)){

        //get the children
        JSONArray children;
        if(item.has("children")){
            children = item.getJSONArray("children");    
        }
        else{
            children = new JSONArray();
            item.put("children", children);
        }

        //append a new child ref to the children
        JSONObject ref = new JSONObject();
        ref.put("_reference", "CHILD-NEXT");
        children.put(ref);

        //create a new child node
        JSONObject newItem = new JSONObject();
        newItem.put("id", "CHILD-NEXT");
        newItem.put("name", "Parent1-ChildNext");
        newItem.put("type", "Child");
        items.put(newItem);
    }
}