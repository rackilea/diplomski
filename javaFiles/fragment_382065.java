listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView email = (TextView) view.findViewById(R.id.email_id);
        String email = email.getText().toString(); // This is your email what you select
        Log.i("Email", "" + email);

        TextView person  = view.findViewById(R.id.person_id); // This is your persion id what you select
        String person  = person .getText().toString();
        Log.i("Person", "" + person);

        modifierButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                }
        );

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});