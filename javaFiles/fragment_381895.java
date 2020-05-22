LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
Switch mySwitch = new Switch(this);
linearLayout.addView(mySwitch);
mySwitch.setBackgroundColor(Color.BLACK);
mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked)
            buttonView.setBackgroundColor(Color.RED);
        else buttonView.setBackgroundColor(Color.BLACK);
    }
});