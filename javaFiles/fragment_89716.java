public String save(View v) {
    // beginning of implementation ommitted for brevity
    Gson gson = new Gson();
    String json = gson.toJson(c);
    return json;
}

public void read(View v, String json) {
    Toast.makeText(this, json, Toast.LENGTH_LONG).show();
}

public void process(View v) {
    String json = save(v);
    read(v, json);
}