@Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this ,SavedDate.class);
                intent.putExtra("ett1", ((TextView)v).getText().toString() + "");

                startActivity(intent);



            }