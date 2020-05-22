int count = radioGroup.getChildCount(); 
    for (int i=0;i<count;i++) {
        View radioButton = radioGroup.getChildAt(i);
        if (radioButton instanceof RadioButton) {
            Log.d(TAG,"text: "+ radioButton.getText().toString());
        }
    }