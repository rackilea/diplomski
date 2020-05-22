public JSONObject getJSONfromURL (String url){
        //HTTP call
        JSONObject object = new JSONObject();
        try{
            URLConnection connection = new URL(url).openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()), 2048 * 16);
            StringBuffer builder = new StringBuffer();
            String line;

            while ((line = reader.readLine()) != null) {
              builder.append(line).append("\n");
            }
            String blah = builder.toString();

            //Parsing string into JSONArray
            object = new JSONObject ( new String(builder.toString()) );
            Log.e("success","created object: " + object);

            } catch(Exception e){
                Log.e("Http Error","Error in http connection " + e.toString());

            }


        return object;
    }