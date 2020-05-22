View view = LayoutInflater.from(this).inflate(R.layout.edit_layout, null, false);
            final EditText editText = view.findViewById(R.id.editText);
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Title")
                    .setView(view)
                    .setPositiveButton("Add", null)
                    .setNegativeButton("Cancel", null)
                    .setCancelable(false);

            AlertDialog dialog = builder.create();
            dialog.show();

            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //fdgdf
                    if(!TextUtils.isEmpty(editText.getText())) {
                        //update RecyclerView
                        dialog.dismis();
                    } else {
                       //Toast to show empty
                    }
                }
            });