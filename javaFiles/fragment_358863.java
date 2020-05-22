CP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    //Pepperoni Listener
    int innerTime = intTime;
    int innerCost = intCost;

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked1) {
        if(isChecked1) {
            pepperoni.setImageResource(R.drawable.pepperoni);
            innerTime += 6;
            innerCost += 5;
        } else {
            pepperoni.setImageResource(0);
            innerTime -= 6;
            innerCost -= 5;
        }
    }
});