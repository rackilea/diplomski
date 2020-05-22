list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked on " + names[position], Toast.LENGTH_LONG).show();

                mselection.setText(names[position]);

            }
        });