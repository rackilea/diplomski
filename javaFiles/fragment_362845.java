//store all selected items in arraylist
 ArrayList<String> selectedItems=new ArrayList<String>();
 final CharSequence[] items = { "Gujrat", "Rajasthan",
                    "Maharastra", "Panjab", "Madhya Pradesh", "Hariyana",
                    "Bihar" };
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Select State");

            builder.setMultiChoiceItems(items, null,
                    new DialogInterface.OnMultiChoiceClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog,
                                int which, boolean isChecked) {
                            // TODO Auto-generated method stub
                            if (isChecked){
                                Toast.makeText(getApplicationContext(),
                                        items[which], Toast.LENGTH_SHORT)
                                        .show();
                              selectedItems.add(items[which]);
                           }else{
                                   if(selectedItems.contains(items[which])
                                          selectedItems.remove(items[which]);
                           }
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }