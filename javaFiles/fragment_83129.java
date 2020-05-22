button.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            Toast.makeText(Context, "some text", Toast.LENGTH_SHORT).show();
            return true;
        }
    });