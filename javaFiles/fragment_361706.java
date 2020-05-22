@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    // Create all the Views, Buttons, etc

    // Create the click handlers:
    button1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            doButtonOneClickActions(position);
        }
     });
}

private void doButtonOneClickActions(int rowNumber) {
    // Do the actions for Button one in row rowNumber (starts at zero)
}