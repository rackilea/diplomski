RadioGroup group=(RadioGroup) findViewById(R.id.radioGroup1);

    group.setOnCheckedChangeListener(new OnCheckedChangeListener() 
       {

        public void onCheckedChanged(RadioGroup group, int checkedId) 
           {
            // TODO Auto-generated method stub
            if(radiobutton1.isChecked())
              {

                        startActivity(new Intent(Welcome.this, Terminate.class));
              }
            else if(radiobutton2.isChecked())
              {

               startActivity(new Intent(Welcome.this, Activity2.class));
              }
         }
    });