String sId = new String[jsonimage.length()];
        String sType = new String[jsonimage.length()];
        String sData = new String[jsonimage.length()];
for (int i = 0 ; i < jsonimage.length(); i++)
        {
            JSONObject c = jsonimage.getJSONObject(i);

            String id = c.getString("id");
            String type = c.getString("type");
            String data = c.getString("data");



            sId[i] = id;
            sType[i] = type;
            sData[i] = data;                

        }