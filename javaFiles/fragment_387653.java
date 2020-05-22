private void addListenerOnButton_ADD(final AlteredCharSequence Snackbar) {
    btnAdd.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            if(ETinput.getText().length()==0){
                Snackbar.make(view, "Enter a Value", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                return;
            }

            int Y = Integer.valueOf(ETinput.getText().toString().trim());
            int Z = Y + X;
            ETans.setText(String.valueOf(Z));

            //float Y = Float.valueOf(ETinput.getText().toString().trim());
            //float Z = Y + X;
            //ETans.setText(String.valueOf(Z));
        }
    });
}