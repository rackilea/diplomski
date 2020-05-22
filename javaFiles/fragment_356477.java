@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    imageView = findViewById(R.id.imageView);
    setBKG = findViewById(R.id.setBKG);

    new URLcollector().execute(websteURL);
    // take it from here...
}

@Override
protected void onPostExecute(ArrayList<String> result) {
    // do something with the result, for example display the received Data in a ListView
    // in this case, "result" would contain the "someLong" variable returned by doInBackground();
    imgURLS = imgURLS2;
    // ...and put it here
    loadImageFromUrl(imgURLS.get(count));


    imageView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
        public void onSwipeRight() {
            Toast.makeText(MainActivity.this, "right : " + imgURLS.size(), Toast.LENGTH_SHORT).show();
            if (count == imgURLS.size() - 1) {
                count = 0;
            } else {
                count++;
            }
            loadImageFromUrl(imgURLS.get(count));
        }

        public void onSwipeLeft() {
            // Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            if (count == 0) {
                count = imgURLS.size() - 1;
            } else {
                count -= 1;
            }
            loadImageFromUrl(imgURLS.get(count));
        }
    });

}