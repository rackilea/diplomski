public View onCreateView(...) {
    rootView = inflater.inflate(...);

    listView = ...;
    listView.setOnTouchListner(...
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false; // Says that click was not handled here. 
        }
    });

    rootView.setOnTouchListner(...
        // TODO: Check if click landed outside the ListView
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (v.getId() != android.R.id.listView) { // Not the list
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Up action more reliable than "down"

                    return true;
                }
            }
        }
    );
    return rootView;
}