JSONObject jObject  = new JSONObject(jsonString);//passing string to jsonobject
         JSONArray jsonArray = jObject.getJSONArray("females");
        for (int i = 0; i < jsonArray.length(); i++) {
         JSONObject object = jsonArray.getJSONObject(i);
         JSONArray jsonObject= object.getJSONArray("actions"); //getting action 
array
       for (int j = 0; j < jsonObject.length(); j++) {
         JSONObject object1 = jsonObject.getJSONObject(j);

           object1.put("action_1", 123); //here you are putting value to action_1
                    object1.put("action_2", 456);
                    object1.put("action_3", 789);
        }
        }