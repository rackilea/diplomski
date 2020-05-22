JSONArray jArray = new JSONArray(array.toString());
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json = jArray.getJSONObject(i);
                    String min = json.getString("min");
                    String max = json.getString("max");
                    //all other data will fetch here
                    array.put(json);
                }