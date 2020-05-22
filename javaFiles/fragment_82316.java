@Override
        public void validate(EditText v, Editable s) {
            // TODO Auto-generated method stub
            Log.i(TAG, "after text change " + s.toString());
            String text = s.toString();
            int length = text.length();
            if(length <= 0) return;
            int max_length = Math.min(length - 1, PATTERNS.length - 1);
            if(!Pattern.matches(PATTERNS[max_length], text)){
                text = s.delete(length - 1, length).toString();
                Log.i(TAG, "the text " + text);
                v.setText(text);
            }
        }