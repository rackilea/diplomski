@NotNull
private JSONObject getJsonObject() {
    JSONObject params = new JSONObject();
    try {
        params.put("amount", "1");
        params.put("currency", "KWD");

        JSONObject receipt = new JSONObject();
        receipt.put("email", "false");
        receipt.put("sms", "true");
        params.put("receipt", receipt);

        JSONObject customer = new JSONObject();
        customer.put("first_name", "test");
        JSONObject phone = new JSONObject();
        phone.put("country_code", "965");
        phone.put("number", "50000000");
        customer.put("phone", phone);
        params.put("customer", customer);

        JSONObject id = new JSONObject();
        id.put("id", "src_kw.knet");
        params.put("source", id);

        JSONObject url = new JSONObject();
        url.put("url", "http://ib7ar.com");

        params.put("redirect", url);
    } catch (JSONException e) {
        e.printStackTrace();
    }

    return params;
}