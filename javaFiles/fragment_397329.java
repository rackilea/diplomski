String s = ""; //Your json string
 JSONObject json = new JSONObject(s);
        JSONArray jsonArray = json.getJSONArray("results");
        Double searchTime  = Double.valueOf(0.22);
        for(int alt=0 ;alt<jsonArray.length(); alt++){
            JSONArray alternatives = jsonArray.getJSONObject(alt).getJSONArray("alternatives");

            for(int tmp=0;tmp<alternatives.length(); tmp++){
                JSONArray timeStamps = alternatives.getJSONObject(tmp).getJSONArray("timestamps");
                for(int t=0;t<timeStamps.length();t++){
                    if(searchTime.equals(timeStamps.getJSONArray(t).getDouble(1))){
                        System.out.println(alternatives);
                        System.out.println(timeStamps.getJSONArray(t));
                    }
                }
            }
        }