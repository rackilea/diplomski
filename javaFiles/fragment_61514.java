JSONObject payload = new JSONObject();
JSONArray products = new JSONArray();

JSONObject product = new JSONObject();
product.putInt("price", 100);
products.add(product);

payload.putArray("products", products);

JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "myLink", payload,
        new Response.Listener<JSONObject>() {