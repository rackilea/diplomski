private class CustomClickListener implements View.OnClickListener {

    private final Dialog dialog;

    CustomClickListener(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void onClick(View v) {
        String editTextValue= mAddWorkout.getText().toString();
    }
}