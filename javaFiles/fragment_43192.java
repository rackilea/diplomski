protected void create(Context context, View v, EditText _writetexthere, int margin) {
    String inputmessage = _writetexthere.getText().toString().trim();
    LinearLayout linearLayout = v.findViewById(R.id.message_layout);
    TextView message = new TextView(context);
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);

    //Gravity to align right
    lp.gravity = Gravity.RIGHT;
    lp.setMargins(0, margin, 0, margin);

    //padding will give space for bubble
    message.setPadding(50, margin, 50, margin);

    message.setLayoutParams(lp);
    message.setText(inputmessage);

    //text size
    message.setTextSize(15);
    message.setBackgroundResource(R.drawable.test_enable);
    message.setTextColor(Color.parseColor("#FFFFFF"));
    linearLayout.addView(message);
}