/**
     * Merge a rowset returned from the API with a table schema.
     *
     * @static
     * @private
     *
     * @param {object} schema
     * @param {array} rows
     * @return {array} Fields using their matching names from the table's schema.
     */
      public static JSONObject mergeRowsWithSchema(JSONArray schemaArr, JSONObject row) {

          JSONObject convertedJson = new JSONObject();
          JSONArray jsonFields = row.getJSONArray("f");
          int i = -1;
          for (Object field : jsonFields) {
              i++;
              JSONObject fieldObj = (JSONObject)field;
              if(fieldObj.isNull("v")) continue;
              Object value = fieldObj.get("v");
              JSONObject schemaField = schemaArr.getJSONObject(i);
              Object convertedValue = null;
              if (schemaField.has("mode") && schemaField.getString("mode").toUpperCase().equals("REPEATED")) {
                  JSONArray convertedArray = new JSONArray();
                  for (Object val : (JSONArray)value) 
                      convertedArray.put(convert(schemaField,((JSONObject)val).get("v")));
                  convertedValue = convertedArray; 

              }
              else
                  convertedValue = convert(schemaField, value);
              convertedJson.put(schemaField.getString("name"), convertedValue);
            }
          return convertedJson;

      }

    private static Object convert(JSONObject schemaField, Object value) {
        if(value == null || value.equals(null)) return value;
        switch (schemaField.getString("type").toUpperCase()) {
          case "STRING": 
              return value;
          case "BOOLEAN": 
                return value.equals("true");
        case "FLOAT": 
           return Float.parseFloat((String)value);
        case "INTEGER":
           return Integer.parseInt((String)value);
        case "RECORD":
              return mergeRowsWithSchema(schemaField.getJSONArray("fields"), (JSONObject)value); 
        case "TIMESTAMP":
              long lng =(long)Double.parseDouble((String)value);
                Date date = new Date(lng * 1000);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                return dateFormat.format(date);
      }
        return null;
    }