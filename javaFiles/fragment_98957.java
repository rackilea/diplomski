if (json.has("ip")) {
        JSONObject jsonObject = getJSONObject.getString("ip")
        String ip_ip_version_raw = jsonObject.getString("ip_ip_version_raw"));
        if (jsonObject.has("ip_ip_addr_raw")){
            JSONArray ip_ip_addr_raw = jsonObject.getJSONArray("ip_ip_addr_raw");
            for (String s : ip_ip_addr_raw) {
                ...
            }
        } 
    }