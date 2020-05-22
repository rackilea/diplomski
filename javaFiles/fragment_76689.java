private class ProcessLogin extends AsyncTask<Void, JSONObject, JSONObject> {

    private ProgressDialog pDialog;
    String username,passwordtxt;

    @Override
    protected JSONObject doInBackground(Void... voids) {
        UserFunctions userFunction = new UserFunctions();
        JSONObject json = userFunction.loginUser(username, passwordtxt);
        return json;
    }

}