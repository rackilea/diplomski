new OnFocusChangeListener() 
 {

            @Override
            public void onFocusChange(View v, boolean hasFocus) 
            {

                if(!hasFocus) 
                { // lost focus
                       v.setEnabled(false);
                }
                else
                {
                    //you are already enabling on button click
                }
            }
  });