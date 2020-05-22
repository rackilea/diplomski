Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        Bundle b = msg.getData();
        String theColor = b.getString("color");

        myView = (View) findViewById(R.id.bigView);
        myView.setBackgroundColor(Color.parseColor(theColor));
    }
};