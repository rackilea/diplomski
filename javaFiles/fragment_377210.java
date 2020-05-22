void showUpdateDialog(String phoneNumber) {


        //init dialog
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setTitle("one more step!");
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.setCancelable(false);
        View sheetView = getLayoutInflater().inflate(R.layout.layout_update_information, null);

        Button btn_update = sheetView.findViewById(R.id.btn_update);
        TextInputEditText edt_name = sheetView.findViewById(R.id.edt_name);
        TextInputEditText edt_email = sheetView.findViewById(R.id.edt_email);
        TextInputEditText edt_address = sheetView.findViewById(R.id.edt_address);
        TextInputEditText edt_gender = sheetView.findViewById(R.id.edt_gender);

        btn_update.setOnClickListener(view -> {

            if (!dialog.isShowing())
                dialog.dismiss();

            User user = new User(edt_name.getText().toString(),
                    edt_email.getText().toString(),
                    edt_address.getText().toString(),
                    phoneNumber,
                    edt_gender.getText().toString(),
                    );
            userRef.document(phoneNumber)
                    .set(user)
                    .addOnSuccessListener(aVoid -> {
                        bottomSheetDialog.dismiss();
                        if (dialog.isShowing())
                            dialog.dismiss();
                        Toast.makeText(HomeActivity.this, " Thank You", Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener(e -> {
                if (dialog.isShowing())
                    dialog.dismiss();
                bottomSheetDialog.dismiss();
                Toast.makeText(HomeActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });

        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();