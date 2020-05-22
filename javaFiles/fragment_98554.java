final TextView txView=(TextView)findViewById(R.id.textView);
    final EditText txtEdit=(EditText)findViewById(R.id.edit);
    Button bt=(Button)findViewById(R.id.btn);
    bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str=txtEdit.getText().toString();
            txView.setText(Html.fromHtml(str));
        }
    });
}