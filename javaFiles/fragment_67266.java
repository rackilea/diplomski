for(i = 0; i < 0; i++) {
    bArr[i].setText("Btn " + i); //Doesn't Work
    rv.setTextViewText(bArr[i].getId(), "Btn " + i); // Doesn't work
    bArr[i].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Btn pressed", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    });
}