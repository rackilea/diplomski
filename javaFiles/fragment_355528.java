while(i.hasNext()) { 
  TextView x = new TextView(this);       
  linearLayout.addView(x);
    x.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
                TextView tv = (TextView) v;
                v.getText();
            }

    });
}