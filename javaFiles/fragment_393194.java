private void mixWheel(int id) {
    WheelView wheel = getWheel(id);
    wheel.scroll(-25 + (int) (Math.random() * 50), 2000);




 }

private String getWheelValue(int id) {
        WheelView wheel = getWheel(R.id.passw_1);
        int index = wheel.getCurrentItem();
        ((ArrayWheelAdapter<String>) wheel.getViewAdapter()).getItemText(index).toString();
        String values = getWheelValue(R.id.passw_1) + " " + getWheelValue(R.id.passw_2) + " " + getWheelValue(R.id.passw_3);
        return values;

        Button share = (Button) findViewById(R.id.tweet);
        share.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getResources().getString(R.string.Subject));
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, getResources().getString(R.string.Message));
            startActivity(emailIntent);

        }
    });

}