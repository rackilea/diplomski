spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                         @Override
                                         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                               switch(position){
                                                  case 0:
                                                            //start activity on selection of any item you want, here I am assuming first item.
                                                            Intent intent = new Intent(YourCurrentActivity.this, ActivityWithButton.class);
                                                            startActivity(intent);
                                                            break;


                                                     }        
                                         }

                                         @Override
                                         public void onNothingSelected(AdapterView<?> parent) {

                                         }
                                     });