private void cancelButton() {

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(isDirty) {
                    //add a dialogue box
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Save changes you made?").setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();
                }
                else {
                    // this will finish the current activity and the last activity will be popped from the stack. 
                    finish();
                }

            }

        });


    }