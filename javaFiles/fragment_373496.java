// 
timepicker.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Initialize a new time picker dialog fragment
            DialogFragment dFragment1 = new TImePicker();

            // Show the time picker dialog fragment
            dFragment1.show(getActivity().getFragmentManager(),"Time Picker");

        }
    });