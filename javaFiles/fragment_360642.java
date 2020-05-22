public class MyActivity extends Activity {

    @Override
    public void onCreate() {
        ...
        View.OnClickListener clickListener = new MyClickListener(minusButton, plusButton, counterDisplay);
        minusButton.setOnClickListener(clickListener);
        plusButton.setOnClickListener(clickListener);
        ...
    }

    ...

    private static class MyClickListener implements View.OnClickListener {

        private final Button minusButton;
        private final Button plusButton;
        private final TextView counterDisplay;

        private counter;

        MyClickListener(Button minusButton, Button plusButton, TextView counterDisplay) {
            this.minusButton = minusButton;
            this.plusButton = plusButton;
            this.counterDisplay = counterDisplay;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == minusButton.getId()) {
                counter--;
            } else if (v.getId() == plusButton.getId()) {
                counter++;
            }

            counterDisplay.setText(String.valueOf(counter));
        }
    }

}