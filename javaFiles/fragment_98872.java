class IncrementButton {
    int step;
    int counter;
    ImageButton add, sub;
    TextView display;

    public IncrementButton(int step) {
        this.step = step;
        add = ...
        sub = ...
        display = ...

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter += step;
                display.setText("" + counter);
                Vibrator vibr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibr.vibrate (20);
            }
        }

        ...

    }
}