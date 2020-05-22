protected void onPostExecute(String result) {
    try {
        JSONArray jsonArray = new JSONArray(result);
        Log.i("JSON", "Number of surveys in feed: " +
        jsonArray.length());

        LinearLayout news = (LinearLayout)findViewById(id.hello);
        //---print out the content of the json feed---
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            final Button button = new Button(getApplicationContext());
            button.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setId(i);
            button.setText(jsonObject.getString("title"));

            final TextView tv = new TextView(getApplicationContext());
            tv.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            tv.setId(i);
            tv.setText(jsonObject.getString("text"));

            news.addView(button);
            news.addView(tv);

            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv.setVisibility(tv.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                }
            });

            Toast.makeText(getBaseContext(), jsonObject.getString("title") +
                    " - " + jsonObject.getString("text"),
                    Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}