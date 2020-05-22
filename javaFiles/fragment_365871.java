U can try with below code. There are many ways to do it, below is one of the way


JSONArray jsonArray = new JSONArray(response.getEntity(String.class));
        for(int i =0; i< jsonArray.length(); i++){
            if(jsonArray.get(i) instanceof JSONObject){
                JSONObject jsnObj = (JSONObject)jsonArray.get(i);
                String finalValue = (String)jsnObj.get("id");
            }
        }