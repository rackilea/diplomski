final EditText taskEditText = new EditText(getActivity());
AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
builder1.setMessage("What do you want to do next?");
builder1.setCancelable(true);

builder1.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //for getting text from the editText
                                String itemText = taskEditText.getText().toString();
                                mItemsAdapter.add(itemText);

                            }
                        });

builder1.setNegativeButton(
   "Cancel", null);

AlertDialog alert11 = builder1.create();

 mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               alert11.show();
            }
        });