String baseUrl = getResources().getString(R.string.login_details_url);
Uri.Builder builder = Uri.parse(baseUrl).buildUpon()
    .appendQueryParameter(USEREMAIL_VAR, email)
    .append...;
HttpPost httppost = new HttpPost(builder.build());
HttpResponse response = httpclient.execute(httppost);