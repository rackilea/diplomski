relativeLayout.setOnClickListener(new OnClickListener() 
         {

            @Override
            public void onClick(View v)
             {
              Intent startActivityIntent = new Intent(getApplicationContext(),YourDesiredActivity.class);
              startActivity(startActivityIntent);
             }
          }