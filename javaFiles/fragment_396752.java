//Listener
        mObsInt = new ObservableInteger();
        mObsInt.set(0);

        mObsInt.setOnIntegerChangeListener(new OnIntegerChangeListener()
        {
            @Override
            public void onIntegerChanged(int newValue)
            {
                if (mObsInt.get()==1)
                   //Do something if the first asyncTask finishes
                if (mObsInt.get()==2){
                   //Do something if the second asyncTask finishes, in this case i just go to another activity when both asyncTasks finish
                    Intent mainIntent = new Intent().setClass(LoginActivity.this, Principal.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        });