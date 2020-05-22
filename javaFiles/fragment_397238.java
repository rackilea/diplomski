btnchk.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View arg0) {
        String email = edt.getText().toString().trim();
        if (email.matches(emailPattern))
        {