mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = mEditText.getText().toString();
            if (s != null && s.length() > 0) {
                mEditText.setText(s.substring(0, s.length()-1));
            }
        }
    });
    mButton.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            mEditText.setText("");
            return true;
        }
    });