//Background Async Task to Get Complete Product Details
class GetProductDetails extends AsyncTask<String, String, JSONObject> {
    //Before starting background thread show progress dialog
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(EditProductActivity.this);
        pDialog.setMessage("Loading product details. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    //getting product details in background thread
    protected JSONObject doInBackground(String... params) {
        //Check for success tag
        int success;
        try {
            //Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("pid", pid));
            //getting product details by making HTTP request
            //Note that product details url will use GET request
            JSONObject json = jsonParser.makeHttpRequest(
                    url_product_details, "GET", params);

            //check your log for json response
            Log.d("Single Product Details", json.toString());
            //json success tag
            success = json.getInt(TAG_SUCCESS);
            if (success == 1) {
                //successfully received product details
                JSONArray productObj = json
                        .getJSONArray(TAG_PRODUCT); //JSON Array

                //get first product object from JSON Array
                JSONObject product = productObj.getJSONObject(0);

                return product;

            } else {
                //product with pid not found
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    //After completing background task dismiss the progress dialog
    protected void onPostExecute(JSONObject product) {
        //Edit text
        txtName = (EditText) findViewById(R.id.inputName);
        txtPrice = (EditText) findViewById(R.id.inputPrice);
        txtDesc = (EditText) findViewById(R.id.inputDesc);

        //display product data in editText
        txtName.setText(product.getString(TAG_NAME));
        txtPrice.setText(product.getString(TAG_PRICE));
        txtDesc.setText(product.getString(TAG_DESCRIPTION));

        //dismiss the dialog once got all details
        pDialog.dismiss();
    }

}