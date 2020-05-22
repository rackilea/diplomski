ArrayList<SalesReciepts> entryList = db.getSalesRecords();

            List<NameValuePair> postVars = new ArrayList<NameValuePair>();

            JSONArray recordsJsonArray = = new JSONArray();


            for (int i = 0; i < entryList.size(); i++) {

                try {
                    JSONObject JSONentry = new JSONObject(); // here you create a new JSONObject

                    JSONentry.put("id", String.valueOf(entryList.get(i).getEntryId()));
                    JSONentry.put("invoice",String.valueOf(entryList.get(i).getInvoice_id()));
                    JSONentry.put("product", String.valueOf(entryList.get(i).getProduct()));
                    JSONentry.put("qty", String.valueOf(entryList.get(i).getQty()));
                    JSONentry.put("total", String.valueOf(entryList.get(i).getTotal()));

                    recordsJsonArray.put(JSONentry); // here you add the item to your array
                }
                catch(JSONException e) {
                    e.printStackTrace();
                }

            }

            JSONObject sent = new JSONObject();

            try {
                sent.put("records", String.valueOf(recordsJsonArray));
            }
            catch(JSONException e) {
                e.printStackTrace();
            }

            postVars.add(new BasicNameValuePair("Entry", String.valueOf(sent)));