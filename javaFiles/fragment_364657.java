JSONArray parentArray = contactsJSON.getJSONArray("row");


                        for (int i = 0; i < parentArray.length(); i++) {
                            JSONObject mainObject = parentArray.getJSONObject(i);
                            JSONArray mainArray = mainObject.getJSONArray("FL");