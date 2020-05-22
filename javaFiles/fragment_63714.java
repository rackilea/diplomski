private String mUrl;
private ArrayList<String> mUrlDove;

HashMap<String, String> params = new HashMap<String, String>();
        params.put("url", mUrl);
        JSONArray jsArray = new JSONArray(mUrlDove);
        params.put("urlDove", jsArray.toString()); 

        mUrl = app.getInstance().getmUrlRestWS() + getString(R.string.path);

        JsonObjectRequest mRequest = new JsonObjectRequest(
                mUrl, new JSONObject(params),
                createMyReqSuccessListener(),
                createMyReqErrorListener()) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return app.getInstance().createBasicAuthHeader();
            }
        };