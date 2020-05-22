dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editTextCode.getText().toString();
                if(code.length() != 6 && !code.matches("[0-9A-F]+")){
                    //Don't dismiss
                } else{
                    dialog.dismiss();
                }
            }
        });