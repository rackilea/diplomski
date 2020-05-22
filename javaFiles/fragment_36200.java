EditText contactLine = new EditText(getActivity());
Drawable drawable =  getActivity().getResources().getDrawable(...);
drawable.setBounds(new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
contactLine.setCompoundDrawables(null, null, drawable, null);
contactLine.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Drawable co =  v.getCompoundDrawables()[2];
            if (co == null) {
                return false;
            }
            if (event.getAction() != MotionEvent.ACTION_DOWN) {
                return false;
            }
            if (event.getX() > v.getMeasuredWidth() - v.getPaddingRight()
                    - co.getIntrinsicWidth()) {
                whatYouWantToDo();
                return true;
            } else {
                return false;
            }
        }
    });