@Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                String value = input.getText().toString().trim();

                if(value.length() <= 0|| value.equals(""){
                    Toast.makeText(MainActivity.this, "Please Enter Pin",
                            Toast.LENGTH_LONG).show();
                }else{
                // Do something with value!
                pins = Integer.parseInt(value);
                if (pins != pindb) {
                    Toast.makeText(MainActivity.this, "wrong",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "correct",
                            Toast.LENGTH_LONG).show();
                    ourDb.open();
                    ourDb.removePin(lockerNumbers, pins, 0);
                    ourDb.close();
                }

                loadListView();
               }
            }
        });