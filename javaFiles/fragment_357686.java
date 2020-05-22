JSONArray jsonArray = new JSONArray(response);
                        String str = (String) jsonArray.get(0);
                        JSONArray arrayTwo = jsonArray.getJSONArray(1);
                        for (int i=0; i<arrayTwo.length(); i++){
                            JSONArray dataArray = arrayTwo.getJSONArray(i);
                            String code = dataArray.getString(i);
                        }