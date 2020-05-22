try{
        JSONObject jsonObject = new JSONObject(documentReceived);
        String data1 = jsonObject.getString("data1");
        String data2 = jsonObject.getString("data2");
        String data3 = jsonObject.getString("data3");

        JSONArray jsonArray = jsonObject.getJSONArray("data4");
        List<String> listSubData = new ArrayList<String>();

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject subDataObject = jsonArray.getJSONObject(i);

            JSONArray subDataArray = subDataObject.getJSONArray("subdata");
            for(int j=0; j<subDataArray.length(); j++){
                JSONObject subSubDataObject = subDataArray.getJSONObject(j);
                String subSubDataStr = subSubDataObject.getString("subsubdata");

                //adding single subsubLineItem to list
                listSubData.add(subSubDataStr);
            }
        }

        //Creating doucumentTransformed object

        jsonObject = new JSONObject();
        jsonObject.put("data1", data1);
        jsonObject.put("data2", data2);
        jsonObject.put("data3", data3);
        jsonArray = new JSONArray();
        for(int i=0; i<listSubData.size(); i++){
            JSONObject subDataObject = new JSONObject();
            JSONObject subSubDataObject = new JSONObject();
            subSubDataObject.put("subsubdata", listSubData.get(i));
            subDataObject.put("subdata", subSubDataObject);
            jsonArray.put(subDataObject);
        }

        jsonObject.put("data4", jsonArray);

        //here is your document transformed data
        System.out.println(jsonObject);
    }catch(Exception e){
        e.printStackTrace();
    }