yourImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            yourImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            //Put your measurements here.
        }
}