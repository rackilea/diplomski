// CONVERT RESPONSE TO STRING
    String result = EntityUtils.toString(response.getEntity());

    // CONVERT RESPONSE STRING TO JSON OBJECT
    JSONObject c = new JSONObject (result);

        // Storing each json item in variable
        companyName = c.getString("name");
        companyEmail = c.getString("email");
        companyAddress = c.getString("address");
        companyCity = c.getString("city");
        companyZip = c.getString("zip");
        companyDescription = c.getString("description");}