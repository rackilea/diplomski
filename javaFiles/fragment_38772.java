public void addListenerOnSpinnerItemSelection(){

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
    }
   - - - 


@Override
            public void onClick(View v) {

                if(v.getId() == btnSubmit.getId())
                {
                    Intent intent = new Intent(beef.this,display.class);
                    intent.putExtra("urlpath", mLink);
                    startActivity(intent);

                }
            }

        });

    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
            long arg3) {
        // TODO Auto-generated method stub
        if(arg2==0){
            mLink="Beef html/BBQ_Meatballs_Recipes.html";
        }
}

@Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }