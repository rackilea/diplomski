class MyListner implements Response.Listener<String> {
    @Override
    public void onResponse(String response) {
        Gson gson = new Gson();
        ArrayList<Test> results = gson.fromJson(response, new TypeToken<ArrayList<Test>>() {}.getType());

        for (Test t : results) {
            Log.e("Tag", t.toString());
        }
    }
}