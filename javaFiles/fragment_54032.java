for(int i = 0; i < services.length(); i++){
    JSONObject service = services.getJSONObject(i);

    tv1 = service.getString("service_id");
    tv2 = service.getString("assigned_time");
    tv3 = service.getString("company_name");
    tv4 = service.getString("user_id");
    tv5 = service.getString("username");
    //for some reason, secondary_number value is escaped which mean 
    //it is a string that you will have to parse
    String secondary_number = service.getString("secondary_number");
    JSONArray secondary_number_json = new JSONArray(secondary_number);

    for(int j = 0; j < secondary_number_json.length(); j++){
        JSONObject secondary = secondary_number_json.getJSONObject(j);
        String name = secondary .getString("name");
        String alternative_no = secondary .getString("alternative_no");
        String designation = secondary .getString("designation");
        // do things with those strings
    }
}