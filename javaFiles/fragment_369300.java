String[] ids = new String[] {"1","2","3","4","5"};
for(int item = 0; item < ids.length; item++) 
 {
       TextView textView = new TextView(this);
       // careful id value should be a positive number.
       textView.setText(ids[item]);
       textView.setId(parseInt(ids[item]));
       ...
  }