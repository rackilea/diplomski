class GetPharmacieDetails extends AsyncTask<String, String, String> {
    /**
     * Before starting background thread Show Progress Dialog
     * */
    private JSONObject product;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Chargement. Patienter ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }
    /**
     * Getting product details in background thread
     * */
    @Override
    protected String doInBackground(String... args) {
        // TODO Auto-generated method stub
        int success;
        try {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("latitude", pid));
            // getting product details by making HTTP request
            // Note that product details url will use GET request
            JSONObject json = jsonParser.makeHttpRequest(
                    url_product_detials, "GET", params);

            // check your log for json response
            Log.d("Single Product Details", json.toString());

            // json success tag
            success = json.getInt(TAG_SUCCESS);
            if (success == 1) {
                // successfully received product details
                JSONArray productObj = json
                        .getJSONArray(TAG_PRODUCT); // JSON Array

                // get first product object from JSON Array
                product = productObj.getJSONObject(0);
            }else{
                // product with pid not found
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    return null;

    }

    /**
     * After completing background task Dismiss the progress dialog
     * **/
    protected void onPostExecute(String file_url) {
        // dismiss the dialog once got all details
        if(null!=product){
            txtName.setText(product.getString(TAG_NAME));
                txtRegion.setText(product.getString(TAG_REGION));
                txtAddress.setText(product.getString(TAG_ADDRESS));
                lati = product.getString(TAG_LATITUDE);
                longi = product.getString(TAG_LANGITUDE);
        }
        if(pDialog != null){
            pDialog.dismiss();
        }

    }
}