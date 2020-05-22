mConfirm2.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(txtDate.getText().toString().length()>0 && txtTime.getText().toString().length() >0 ){
            ParseUser currentUser = ParseUser.getCurrentUser();

         // Create the class and the columns
            currentUser.saveInBackground();

            currentUser.put("ActivityDate", txtDate); 
            currentUser.put("ActivityTime", txtTime);
            currentUser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    setProgressBarIndeterminateVisibility(false);

                    if (e == null) {
                        // Success!

                    }
                    else {

                    }
             }
         });
       }else{
               Toast t = t.makeText(context,"Please fill all the details !",Toast.Length_LONG);
                t.setGravity(Gravity.center,0,0);
                t.show();


        }
    });