mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                mBottomSheetBehavior.setPeekHeight(0);
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    });

@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btn_negetive: {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            mBottomSheetBehavior.setPeekHeight(Constants.PEEK_HEIGHT);
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            break;
        }
        case R.id.btn_positive: {
            //some code
        }
    }
}