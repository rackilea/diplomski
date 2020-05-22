Spinner mMembership = (Spinner) findViewById(R.id.RegisterMembershipSpinner);
    ArrayAdapter<CharSequence> member_adapter = ArrayAdapter.createFromResource(this,
            R.array.membership_array, R.layout.spinner_items);
    // Specify the layout to use when the list of choices appears
    member_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    mMembership.setAdapter(member_adapter);