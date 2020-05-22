private OnClickListener onCounterButtonClick  = new OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast toast = Toast.makeText(MainActivity.this, "Button was clicked", Toast.LENGTH_LONG);
            toast.show();
        }
    };
}