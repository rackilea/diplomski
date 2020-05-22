protected String doInBackground(String... args) {
    String driver = inputDriver.getText().toString();
    String licencenum = inputLicence.getText().toString();
    String officer = inputOfficer.getText().toString();
    String speed = inputSpeed.getText().toString();
    String fine= FineAppl.getText().toString();
    String category = inputCategory.getText().toString();


    // Building Parameters
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("driver", driver));
    params.add(new BasicNameValuePair("licencenum", licencenum));
    params.add(new BasicNameValuePair("officer", officer));
    params.add(new BasicNameValuePair("speed", speed));
    params.add(new BasicNameValuePair("fine", fine));
    params.add(new BasicNameValuePair("category", category));

    // getting JSON String
    // Note that create product url accepts POST method
    String json = jsonParser.makeHttpRequest(url_create_fine, params);

    return json;
}



protected void onPostExecute(String json) {
    // dismiss the dialog once done
    pDialog.dismiss();
    Log.d("mylog", "json = " + json);
    //parse here
}