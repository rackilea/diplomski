JSONArray jsonT1Array = jsonOrder.getJSONObject("vendors").getJSONArray("T1");
 for(int i = 0; i < jsonT1Array.length(); i++) {
    // Get the objects in T1 array
    JSONObject objectInArray = jsonT1Array.getJSONObject(i).getJSONObject("data"); 

    // Then get the JSONArray you want
    JSONArray jsonOrderArray = objectInArray.getJSONArray("orderinfo");

    // You may iterate again over ordeinfo array
    for(int j = 0; j < jsonOrderArray.length(); j++) {
        JSONObject objectInOrderArray = jsonOrderArray.getJSONObject(j);
        String orderNumber = objectInOrderArray.getString("contact_phone_no");
    }
 }