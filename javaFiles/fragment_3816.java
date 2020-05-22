editActivity.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            firstPerson.setPersonName(editName.getText().toString());
            firstPerson.setPersonAge(Integer.parseInt(editAge.getText().toString()));
            firstPerson.setPersonHeight(Integer.parseInt(editHeight.getText().toString()));
            firstPerson.setPersonWeight(Integer.parseInt(editWeight.getText().toString()));
            Intent editIntent = new Intent(MainActivity.this, EditData.class);
            editIntent.putExtra("First_Person_Data", firstPerson);
            MainActivity.this.startActivity(editIntent);
        }
    });

MainActivity.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent EditActivity = new Intent(EditData.this, MainActivity.class);
            // put your extra here 
            EditData.this.startActivity(EditActivity);
        }
    });