HashMap<String, Integer> count = new HashMap<>();
                     try {
                        JSONObject object = response.getJSONObject("count");
                        Iterator a = object.keys();
                        while (a.hasNext()) {
                            String key = (String) a.next();
                            // loop to get the dynamic key
                            Integer value = (Integer) object.get(key);
                            Log.e("count : ","Keys :"+ key+"   Values :"+value);
                            count.put(key, value);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }