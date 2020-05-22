@Override
    protected void onResume() {
        super.onResume();
        mUserNameEdit.requestFocus();

        mUserNameEdit.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                InputMethodManager keyboard = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(mUserNameEdit, 0);
            }
        },200);
    }