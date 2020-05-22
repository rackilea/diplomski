@Override
        public void validate(EditText v, Editable s) {
            // TODO Auto-generated method stub
            Log.i(TAG, "after text change " + s.toString());
            String text = s.toString();
            int length = text.length();
            if(length <= 0) return;
            if(!Pattern.matches(PATTERNS[length - 1], text)){
                text = s.delete(length - 1, length).toString();
                v.setText(text);
            }
        }