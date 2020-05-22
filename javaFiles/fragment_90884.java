while(iterator.hasNext()){
        JSONObject jsonObject2 = (JSONObject) iterator.next();
        if(jsonObject2.get("wi_name").equals("START")){
                System.out.println(jsonObject2.get("wi_displayName"));
        }
    }