builder.setPositiveButton(R.string.start_test, new DialogInterface.OnClickListener() {            
    @Override
    public void onClick(DialogInterface dialog, int id) {
        String filename = editText.getText().toString();
        Context context = getContext();
        Intent intent = new Intent(context, InitializeTest.class);
        intent.putExtra(FILENAME, filename);
        context.startActivity(intent);
    }
});