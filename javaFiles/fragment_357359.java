OnClickListener mListener = new OnClickListener() {
    public void onClick(View view) {
        TextView text = (TextView) view.getTag();

        if(((Button) view).getText().equals("+"))
            text.setText(Integer.parseInt(text.getText().toString()) + 1 + "");
        else
            text.setText(Integer.parseInt(text.getText().toString()) - 1 + "");
    }
};
...


while (counter < 5) {
    inflaterLayout = LayoutInflater.from(getBaseContext()).inflate(R.layout.newplayerlayout, null);
    myLayout.addView(inflaterLayout);

    TextView inflatedText = (TextView) inflaterLayout.findViewById(R.id.text);
    Button testButton = (Button) inflaterLayout.findViewById(R.id.plus);
    testButton.setTag(inflatedText);
    testButton.setText("+");
    testButton.setOnClickListener(mListener);

    testButton = (Button) inflaterLayout.findViewById(R.id.minus);
    testButton.setTag(inflatedText);
    testButton.setText("-");
    testButton.setOnClickListener(mListener);

    counter++;
}