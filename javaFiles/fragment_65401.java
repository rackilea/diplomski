ProfilUpdate.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFirstClick){
                //Do the job for the first click process 
                isFirstClick= false;
                }else {
                //Do the job for the second click process
                isFirstClick= true;
                }

            }
        };
        ProfilUpdate.setOnClickListener(listener);