listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
                    String selectedSweet = listView.getItemAtPosition(position).toString();


                    TextView textView = (TextView) view.findViewById(R.id.sweetName);
                    String text = textView.getText().toString();
                    Toast.makeText(getApplicationContext(), "Selected item: " + text + " - " + position, Toast.LENGTH_SHORT).show();

                }
            }
    );