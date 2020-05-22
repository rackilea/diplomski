Button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            updateDatabse("some input");

            notifyDataSetChanged();
        }
    });