List<String> inputs=new ArrayList<>();
    LinearLayout rootView=findViewById(R.id.yourrootElementId);

      //if your root element type is not LineareLayout replace LinearLayout with your root 
     //element type for Example ConstraintLayout
    for (int i = 0; i < rootView.getChildCount(); i++) {
        View child = rootView.getChildAt(i);
        if (child instanceof EditText)
        {
            String text=((EditText) child).getText().toString().trim();
            inputs.add(text);
        }
    }