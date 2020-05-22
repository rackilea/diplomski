@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onActivityCreated(savedInstanceState);

    this.getView().setFocusableInTouchMode(true);
    this.getView().requestFocus();
    this.getView().setOnKeyListener(new OnKeyListener() {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            // TODO Auto-generated method stub
            if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                // Write code here to save data

                return true;
            }
            return false;
        }
    });