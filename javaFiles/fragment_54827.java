public void agencySearch(String tsearch)    {
        // Setting the URL for the Search by Town
        String url_search_agency = "http://www.infinitycodeservices.com/get_agency_by_city.php";
        // Building parameters for the search
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("City", tsearch));

        // Getting JSON string from URL
        JSONArray json = jParser.getJSONFromUrl(url_search_agency, params);

       ArrayList<HashMap<String, String>> resultsList = new  ArrayList<HashMap<String, String>>();

        for (int i = 0; i < json.length(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();

            try {
                JSONObject c = json.getJSONObject(position);
                //Fill map
               Iterator<String> iter = c.keys();
                while(iter.hasNext())   {
                    String currentKey = it.next();
                    map.put(currentKey, c.getString(currentKey));
                }
                resultsList.add(map);

            }
            catch (JSONException e) {
                e.printStackTrace();

            }

        };

        MainActivity.setResultsList(resultsList);

    }