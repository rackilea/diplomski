LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
final Switch mySwitch = new Switch(this);
linearLayout.addView(mySwitch);
mySwitch.getThumbDrawable().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked)
            mySwitch.getThumbDrawable().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        else
            mySwitch.getThumbDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
    }
});