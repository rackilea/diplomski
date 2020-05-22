mMembership = (Spinner) findViewById(R.id.RegisterMembershipSpinner);
    ArrayAdapter<CharSequence> member_adapter = ArrayAdapter.createFromResource(this,
            R.array.membership_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    member_adapter.setDropDownViewResource(R.layout.spinner_items);
    // Apply the adapter to the spinner
    mMembership.setAdapter(member_adapter);