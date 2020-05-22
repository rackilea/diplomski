ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.autocomplete_item,options);
 // R.layout.autocomplete_item is custom spinner item xml file.you can use default spinner item also.
autoComplete.setAdapter(adapter); 
autoComplete.setThreshold(1);
autoComplete.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                    long arg3) {

        Intent intent;
        int index=999;
        for(int i=0;i<options.length;i++)
        {
            if(options[i].equals(autoComplete.getText().toString().trim()))
            {
                index=i;
                break;
            }
        }
        switch(index)
        {
            case 0:
                intent=new Intent(ThisActivity.this,ActivityZero.class);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(ThisActivity.this,ActivityOne.class);
                startActivity(intent);   
                break; 
                ...         
        }
    }
});