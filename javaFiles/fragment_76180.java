private ClipboardManager myClipboard;
 private ClipData myClip;

 //inside oncreate
 myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);



 mEditText.setOnLongClickListener(new OnLongClickListener() { 
        @Override
        public boolean onLongClick(View v) {
           String text;
            text = mEditText.getText().toString();

            myClip = ClipData.newPlainText("text", text);
            myClipboard.setPrimaryClip(myClip);

            Toast.makeText(getApplicationContext(), "Text Copied", 
               Toast.LENGTH_SHORT).show();

            return true;
        }
    });