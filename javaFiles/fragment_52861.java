TextWatcher t = new TextWatcher() {
        long lastChange = 0;

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {

            // TODO Auto-generated method stub
            if (s.length() > 3) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (System.currentTimeMillis() - lastChange >= 300) {
                            //send request
                        }
                    }
                }, 300);
                lastChange = System.currentTimeMillis();

            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

        }
};