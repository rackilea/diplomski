@Override
protected Map<String, String> getParams() throws AuthFailureError {
    Map<String, String> parameters = new HashMap<>();
        parameters.put("key", value);
        return parameters;
    }