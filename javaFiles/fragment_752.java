// take the reference of LinearLayout
linearLayout = (LinearLayout) romptView.findViewById(R.id.layoutDynamic);


// Take the reference of Add button 

Button addButton = (Button) rootView.findViewById(R.id.add_another_device_button);

addButton.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        final View addView = layoutInflater1.inflate(R.layout.dynamic_row, null);
        final TextView textView1 = (TextView) addView.findViewById(R.id.etDynamic);        
        textView1.setText(otheret.getText().toString().trim());                                                                           otheret.setText("");                                        linearLayout.addView(addView);    
    }
});


#and if you want to remove particular item
removeIcon.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        addView.getParent()).removeView(addView);
    }
});