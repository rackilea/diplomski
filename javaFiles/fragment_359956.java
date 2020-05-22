private int viewHeight = 0;
View view = findViewByID(R.id.idOfTheView);
view.getViewTreeObserver().addOnGlobalLayoutListener( 
    new OnGlobalLayoutListener(){
        @Override
        public void onGlobalLayout() {
            viewHeight = view.getHeight();
        }