for(Object obj : members.getJsonObject(0).getJSONArray("characters")) {

           JSONObject p = (JSONObject) obj;
           System.out.println(p.get("name");
           System.out.println(p.get("status");
           }