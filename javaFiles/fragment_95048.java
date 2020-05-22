buttonConfirm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Records the gender from the selected radio button.
            int radioID = radioGroup.getCheckedRadioButtonId();
            radioButton = v.findViewById(radioID);
            if (radioButton.getText().equals("Male")) {
                gender = (float) .58;
            } else {
                gender = (float) .49;
            }
         ......