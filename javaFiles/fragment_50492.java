final Dialog splitDialog = new Dialog(this);
     splitDialog.setContentView(R.layout.abc_action_bar_decoryour_dialog_layout);
    //Button that you want to toggle the editText enabled
    Button btn = splitDialog.findViewById(R.id.your_button);
    btn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            EditText editText =splitDialog.findViewById(R.id.your_edit_text);
            editText.setEnabled(true);
            editText.requestFocus();
        }
    });
    splitDialog.show();