JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
        JSONObject fieldsObject = jsonChildNode.getJSONObject("custom_fields");
        JSONArray idArray = fieldsObject.getJSONArray("id");
        String idValue = idArray.getString(0);

        JSONArray nameArray = fieldsObject.getJSONArray("name");
        String nameValue = nameArray.getString(0);

        JSONArray passArray = fieldsObject.getJSONArray("pass");
        String passValue = passArray.getString(0);

        JSONArray clientArray = fieldsObject.getJSONArray("client_type");
        String clientValue = clientArray.getString(0);