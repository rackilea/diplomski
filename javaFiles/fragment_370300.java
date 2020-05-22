for ( final Entry<String, JsonElement> queryResult : shodanJsonObject.entrySet() ) {
        final JsonElement value = queryResult.getValue();
        // This is necessary to skip <"total": 2>
        if ( value.isJsonArray() ) {
            // Here comes an array, and should be iterated, rather than taken as an object
            for ( final JsonElement match : value.getAsJsonArray() ) {
                // This was the root cause, not an array
                final JsonObject location = match.getAsJsonObject().getAsJsonObject("location");
                // Previously jsonPrimitive.equals("US") -- convert the JSON primitive to a string first
                if ( location.getAsJsonPrimitive("country_code").getAsString().equals("US") ) {
                    // Previously getAsString() -- it requires a JSON string literal, just remove it
                    System.out.println(match);
                }
            }
        }
    }