Button button2 = (Button) v.findViewById(R.id.next);
    button2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       android.app.FragmentManager fn = getFragmentManager();
                                       fn.beginTransaction().replace(R.id.container, new next()).addToBackStack( "tag" ).commit();


                                   }
                               }

    );