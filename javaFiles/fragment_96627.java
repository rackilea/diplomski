private void submitForm() throws IOException {
    try
    {
        urlAPI = new URL("http://testsiteprog.com./accounts/signin.php");
    }
    catch (MalformedURLException e)
    {
        e.printStackTrace();
    }

    OkHttpClient client = new OkHttpClient();

    //INPUT *GETTEXT
    JSONObject jsonObject = new JSONObject();
    try {
        jsonObject.put("username", login_username.getText().toString());
        jsonObject.put("password", login_password.getText().toString());
        jsonObject.put("ipaddress", get_publicIPaddress);
    }
    catch (JSONException e) {
        e.printStackTrace();
    }

    MediaType JSON =MediaType.parse("application/json; charset=utf-8");

    RequestBody requestBody =  RequestBody.create(JSON, jsonObject.toString());
    Log.i("LOG_INTENT", login_username.getText().toString() + login_password.getText().toString() + get_publicIPaddress);

    Request request = new Request.Builder()
        .url(urlAPI)
        .post(requestBody)
        .build();


    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            String mMessage = e.getMessage();
            Log.w("failure Response", mMessage);
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String mMessage = response.body().string();

            try {
                JSONObject object = new JSONObject(mMessage);
                responseCode = object.getString("code");
                responseMsg = object.getString("message");
                responseToken = object.getString("token");

                if(response.code() == 200) {
                    Intent intentHome = new Intent(LoginActivity.this, HomeActivity.class);
                    intentHome.putExtra("TOKEN", responseToken);
                    Log.i("TAG", "Login Activity" + responseToken);
                    startActivity(intentHome);

                    Log.i("INTENT", "NAKUKUHA BA AT NATAPOS?");
                }
                else if(response.code() == 400){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(LoginActivity.this, responseMsg, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            Log.i("RESPONSE",  response + mMessage + "code" + responseCode + responseToken );
        }
    });

    Log.i("GET", "NAKUKUHA BA AT NATAPOS?");
}