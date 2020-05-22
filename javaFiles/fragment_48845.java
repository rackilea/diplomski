private InputStream getResources(String s) {
    return null;
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = (Button) findViewById(R.id.btn);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("text/plain");
            startActivityForResult(intent, 7);
            Log.v("###", "parent " + getParent());
        }

    });
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Uri PathHolder = data.getData();
    Log.v("###", "yo " + PathHolder);

    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case 7:
            if (resultCode == RESULT_OK) {
                setContentView(R.layout.activity_main);

                try {
                    InputStream inputStream = getContentResolver().openInputStream(PathHolder);
                    BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
                    String mLine;
                    while ((mLine = r.readLine()) != null) {
                        text.append(mLine);
                        text.append('\n');
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }