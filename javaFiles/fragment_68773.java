final List<String> list = new ArrayList<String>();
list.add(textView3.getText().toString());
list.add(textView4.getText().toString());
list.add(textView5.getText().toString());


@Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this ,SavedDate.class);
                intent.putExtra("ett1", list.get(0) + "");
                intent.putExtra("ett2", list.get(1) + "");
                intent.putExtra("ett3", list.get(2) + "");

                startActivity(intent);



            }