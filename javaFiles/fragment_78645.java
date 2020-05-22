try {
    // Create new buffer
    final Buffer buffer = new Buffer();

    // Copy original request's json body to buffer
    chain.request().body().writeTo(buffer);

    // Convert buffer to JSONObject
    JSONObject params = new JSONObject(buffer.readUtf8());

    // Append new params
    params.put("version", "6");
    params.put("os", "2");

    // Now the params json object will have all 4 values: email,password,os,version

    // TODO: Your remaining code

} catch (Exception ex) {
    Log.d("Login","Error creating post body", ex);
}