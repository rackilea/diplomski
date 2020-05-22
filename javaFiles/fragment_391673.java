jObject = new JSONObject(String to json);
            JSONArray jArray = jObject.getJSONArray("routes");
            for(int i=0; i<jArray.length(); i++){
                JSONArray array = jArray.getJSONObject(i).getJSONArray("legs");
                for(int j=0; j<array.length(); j++){
                    String text = array.getJSONObject(j).getJSONObject("duration").getString("text");
                }
            }