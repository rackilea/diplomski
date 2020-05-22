one_next_diaspora_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String Name = name_diaspora_edt.getText().toString().trim();
                if(Name.matches("")){


                    Toast.makeText(getApplicationContext(),"Make sure that you have filled your name please !!!",Toast.LENGTH_LONG).show();


                }

                else{



                    Intent i = new Intent(Diaspora.this,DiasporaTwo.class);
                    i.putExtra("Name",Name);
                    i.putExtra("Age",Age);
                    i.putExtra("Gender",Gender);
                    i.putExtra("MaritalStatus",MaritalStatus);
                    startActivity(i);
                }
            }
        });
}