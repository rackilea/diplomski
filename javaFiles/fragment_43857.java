public class MyClass extends AppCompatActivity {

    String[] data = new String[4];

    public void populateGrid() {
        getIndexData(indices);
    }

    public void getIndexData(final String indices) {

        // set up http request

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // ...
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // process the response, populate data etc.

                final TextView test = (TextView) findViewById(R.id.textView0B);
                test.post(new Runnable() {
                    @Override
                    public void run() {
                        test.setText(data[1]);
                    }
                });
            }
        }
    }
}