public void onClickEditTask(View view){
    String editedInput = ((EditText)findViewById(R.id.edit_task)).getText().toString();
    if(editedInput.length() == 0){
        return;
    }

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Test");
    builder.setCancelable(true);
    builder.setNeutralButton("TEST", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.d("TAG","You click the TEST button of the dialog.");
        }
    });
    builder.show();
}