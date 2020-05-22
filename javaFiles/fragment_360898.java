try {
            JSONArray jsonimage = new JSONArray();
            JSONArray jsontext = new JSONArray();
            jsonArray = new JSONArray(result);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = (JSONObject)jsonArray.get(i); // get the josn object
                if(jsonObj.getString("type").equals("image")) { // compare for the key-value

                    jsonimage.put(jsonObj);
                    k++;

                }
                if(jsonObj.getString("type").equals("text")) { // compare for the key-value
                    jsontext.put(jsonObj);
                    j++;
                }
            }
            Toast.makeText(getApplicationContext(), String.valueOf(k), 2000).show();
            Toast.makeText(getApplicationContext(), String.valueOf(j), 2000).show();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }