valueET.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if (etCurrent != null) {
                if (etCurrent.getId() != v.getId()) {

                    if (!check(etCurrent.getId())) {
                        etCurrent.setSelection(0,
                             etCurrent.getText().toString().length());
                        return true;
                    } else {
                        etCurrent = (EditText) v;
                    }
                }
            } else {
                etCurrent = (EditText) v;
            }
      }
    return false;
    }
});