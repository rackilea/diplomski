@Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                switch(arg2){
                 case(1):
                  Intent iinent= new Intent(Homeactivity.this,SettingsActivity.class);
                  startActivity(iinent);

                  }                    
                }