final TextView t1 = (TextView) findViewById(R.id.yourpay);

final Timer t =new Timer();
t.schedule(new TimerTask() {

    @Override
    public void run() {
        runOnUiThread(new Runnable() {

            public void run() {
                money = (PPS+Reserve);
                Reserve = (money);
                t1.setText("$" + money); //Place your text data here

                // Removed the stopping condition/counter

            }
        }); 
    }
}, 1000, 1000); // Do you really want to wait 1 second before executing the timer's code?  If not, change the 1st "1000" to a "0"


final Button b = (Button) findViewById(R.id.my_button_id); // Replace with your button's id
b.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        if (t != null)
            t.cancel();
        }
});