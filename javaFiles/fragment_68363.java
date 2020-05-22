@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        Ion.with(MyActivity.this)
                .load(getString(R.string.json_url))
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (e != null) {
                            Toast.makeText(MyJson.this, "Error loading strings", Toast.LENGTH_LONG).show();
                            return;
                        }
                        JsonObject c = result.get(0).getAsJsonObject();
                        if (c.has("title")) title = c.get("title").getAsString();
                        if (c.has("text")) text = c.get("text").getAsString();


                    }
                });

    }