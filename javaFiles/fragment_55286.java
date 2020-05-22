@Override
public void onClick(View v) {
    boolean on = ((ToggleButton) v).isChecked();
    StartCalc session = new StartCalc(MainActivity.this); //im assuming its called main activity
    Intent timeServiceIntent = new Intent(this, TimeService.class);

    if (on == true) {
        button = true;
        Log.d(TAG, "Button Clicked");
        // session.TimeClock();
        startService(timeServiceIntent);
    } else {
        button = false;
        // Log.d(TAG, "Not Running");
        // session.calculateWeekly();
        try {
            tvTotal.setText(Float.toString(session.CalculateWeekly()));
        } catch (Exception e) {
            Log.d(TAG, "Set text didn't work...");
            e.printStackTrace();

        }
        Toast.makeText(Home.this, "Calculating...", Toast.LENGTH_SHORT).show();
    }

}