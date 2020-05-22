final View yourView = View.inflate(....);
    ViewTreeObserver observer = yourView .getViewTreeObserver();

    observer.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

        @Override
        public void onGlobalLayout() {
            yourView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            // Do what you need with yourView here...

        }
    });