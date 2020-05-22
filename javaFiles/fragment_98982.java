private void initiatePopupWindow() {
    try {
        LayoutInflater inflater = (LayoutInflater) Environment.this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.annotation,
                (ViewGroup) findViewById(R.id.popup_element));
        pwindo = new PopupWindow(layout, 1000, 1200, true);
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

        bar = (SeekBar)layout.findViewById(R.id.seekBar1); // make seekbar object
        bar.setOnSeekBarChangeListener(this);
        textProgress = (TextView)layout.findViewById(R.id.textViewProgress);

        textAction = (TextView)layout.findViewById(R.id.textViewAction);

    } catch (Exception e) {
        e.printStackTrace();
    }
}