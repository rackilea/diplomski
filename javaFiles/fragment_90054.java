JSONObject jobj = new JSONObject(stringJson);
JSONArray flowNodeInv = jobj.getJSONArray("flow-node-inventory:flow");
    for (int i = 0; i < flowNodeInv.length(); i++){
          JSONObject segment = (JSONObject) flowNodeInv.get(i);
          JSONObject stats = segment.getJSONObject("opendaylight-flow-statistics:flow-statistics");

        int number = stats.getInt("packet-count");

       System.out.println("packet-count: "+ number);}