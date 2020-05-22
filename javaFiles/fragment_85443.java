Bundle extras = getIntent().getExtras();
if (extras != null) {
            itemProductName.setText(extras.getString("product"));
            itemPrice.setText(extras.getString("price"));

//Here is the one change 

            final String itemID = extras.getString("id");

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        dbHandler.updateItem(itemID);
                        Toast.makeText(ItemDetail.this, itemProductName.getText().toString() + " was modified", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ItemDetail.this, MainActivity.class));
                    }
                }
            });
    }