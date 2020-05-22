@Override 
    public void onClick(View view) {
        if(value.getText().toString().trim().length() != 0) { 
             String order = value.getText().toString(); //The value i want in Fragment B
             //return to Fragment A 

            FragmentA fragment = new FragmentA();
            Bundle args=new Bundle();
            args.putString(order);
           fragment.setArguments(args);
           getFragmentManager().beginTransaction().replace((R.id.content_frame,fragment).commit();


        }