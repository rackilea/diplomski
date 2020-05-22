try {
                JSONObject root = new JSONObject("YOUR_JSON");
                JSONObject team = root.getJSONObject("Teams").getJSONObject("FC Barcelona");
                Iterator keys =  team.keys(); 

                //iterate each object
                while (keys.hasNext()){
                    JSONObject obj = team.getJSONObject((String)keys.next());
                    String age = obj.getString("age");
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }