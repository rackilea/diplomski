OnClickListener button_listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), Integer.toString(v.getId()), Toast.LENGTH_SHORT)
            .show();
        }
    };