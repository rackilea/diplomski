button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Initialize a new time picker dialog fragment
            DialogFragment dFragment = new TimePickerFragment();

            // Show the time picker dialog fragment
            dFragment.show(getFragmentManager(),"Time Picker");
        }
    });