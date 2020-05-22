JSONObject json = parser.getJSONFromUrl(URL);
try {
    id = json.getString(TAG_ID);             // Changes here
    page = json.getString(TAG_page);         // Changes here

    pages = json.getString(TAG_total_pages);  // Changes here

    tot_result = json.getString(TAG_total_results);  // Changes here

    results = json.getJSONArray(TAG_results);       // Add this line

    for (int i = 0; i < results.length(); i++) {
          // Remaining all correct
    }