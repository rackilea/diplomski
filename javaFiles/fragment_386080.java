LinearLayout dynamicHolder = (LineraLayout) findViewById(R.id.dynamic_holder);

for(int i = 0; i<your_message_length; i++){
    View dynamicView = LayoutInflater.from(context).inflate(R.layout.my_linear_layout, null, false);
    TextView yourTextView = (TextView) dynamicView.findViewById(R.id.your_tv_id);//give id to your textview in my_linear_layout
    youtTextView.setText(your_each_message_from_db);

    dynamicHolder.addView(dynamicView);
}