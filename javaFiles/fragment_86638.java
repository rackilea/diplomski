int count = parentLinearLayout.getChildCount();

     for(int i=0; i<count; i++) {
         LinearLayout linearLayout = (LinearLayout)parentLinearLayout.getChildAt(i);
         Spinner spinnerField = (Spinner)linearLayout.getChildAt(1);
         String result = spinnerField.getSelectedItem().toString();
         //You can result get data from spinner value.
     }