JSONString = new String(bytes, "UTF-8");
        JSONObject = new JSONObject(JSONString);

        // Get the JSON Object from the data
        JSONObject parent = this.parseJSONData(); // <-- this line

        // This will store all the values inside "Hydrogen" in an element string
        String element = parent.getString("Hydrogen");