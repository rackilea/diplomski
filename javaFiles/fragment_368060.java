btnEdit.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(ViewRequestActivity, EditRequestActivity.class);
            i.putExtra("DATA", "" + your_value);

            startActivity(i);

        }
    });