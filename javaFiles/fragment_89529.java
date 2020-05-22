View.OnClickListener listenerToCheckColor = new View.OnClickListener () {
    @Override
    public void onClick(View v) {
        Button button = (Button)v;
        if (((ColorDrawable)button.getBackground()).getColor() == yourGreenColor)
        {
            // + 1 point
        }
    }
});