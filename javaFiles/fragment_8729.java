mButton.setOnClickListener(new View.OnClickListener()
{
    public void onClick(View view)
    {
        String [] mArray = getResources().getStringArray(R.array.password);

        // loop to check all passwords
        for (String s : mArray) {
            if (s.equals(mEdit.getText().toString())) {
                // found the password
                Intent intent = new Intent(this, secondactivity.class);
                startActivity(intent);
                return;
            }
        }

        mEdit.setTextColor(Color.RED);

    }
});