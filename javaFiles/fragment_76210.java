String json = "{
              "Classes": {
                "Primary": {
                  "Classes": {
                    "1": {
                      "section": [
                        "a",
                        "b"
                      ]
                    },
                    "2": {
                      "sections": [
                        "a",
                        "b"
                      ]
                    }
                  }
                }
              }
            }";

            try {
                JSONObject jsonObject = new JSONObject(json);
                Log.d("jsonObj", jsonObject.toString());

                JSONObject classJsonObj = jsonObject.optJSONObject("Classes");
                JSONObject primaryJsonObj = classJsonObj.optJSONObject("Primary");
                JSONObject internalClassJsonObj = primaryJsonObj.optJSONObject("Classes");

                if(internalClassJsonObj != null){
                    int i = 1;
                    JSONObject dynmaicInternalJsonObj = null;
                    while (true){
                        dynmaicInternalJsonObj = internalClassJsonObj.optJSONObject(i+"");
                        if(dynmaicInternalJsonObj != null){
                            JSONArray sectionJsonArr = dynmaicInternalJsonObj.optJSONArray("sections");
                            Log.d("SectionArr", sectionJsonArr.toString());

                            // Finally you got your section data here...
                            if(sectionJsonArr != null){
                                for(int j=0; j<sectionJsonArr.length(); j++){
                                    System.out.println("Dynamic Sections Data is: - " + sectionJsonArr.opt(j));
                                }

                                System.out.println("\n\n");
                            }

                        }else{
                            break;
                        }

                        i++;
                    }

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }