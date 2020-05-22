private static class MyClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        counter -= 1; // ERROR - cannot resolve 
        counterDisplay.setText(String.valueOf(counter)); // ERROR cannot resolve
    }
}