if (!my_json_object_from_file.isNull("rules")) {
        JSONArray rules_array = my_json_object_from_file.getJSONArray("rules");
        for (JSONObject rule_object : rules_array) {
            if (!rule_object.isNull("name")) {
                // you have a name for the rule
            }
            if (!rule_object.isNull("patterns")) {
                // you have some patterns
                JSONArray pattern_array = rule_object.getJSONArray("patterns");
                for (JSONObject pattern_object : pattern_array) {
                    // these are your pattern objects
                    if (!pattern_object.isNull("regex")) {
                        String regex = pattern_object.getString("regex");
                        // do work with the regex
                    }
                }
            }
        }
    }