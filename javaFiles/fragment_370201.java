public void displayNoteDate(String noteContent, String dateValue) {
    final Dialog builder = new Dialog(this);
    builder.setContentView(R.layout.custom_dialog);

    builder.setTitle("Display note date");

    TextView note = (TextView)builder.findViewById(R.id.note);
    TextView date = (TextView)builder.findViewById(R.id.date);

    //add the database note and date
    note.setText(noteContent);
    date.setText(dateValue);

    Button closeButton = (Button)builder.findViewById(R.id.close);
    closeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            builder.dismiss();
        }
    });
    builder.show();
}