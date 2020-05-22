public MyActivity extends Activity implements MyFragment.Callback {

    ...
    @Override
    public void onRadioButtonClicked(View radioButton) {
        // The radiobutton in MyFragment has been clicked
        myButton.setEnabled(true); // or something like this.
    }

}