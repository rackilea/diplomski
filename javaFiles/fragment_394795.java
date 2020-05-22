private Optional<? extends Runnable> backButtonListener = Optional.absent();

@Override
public void onBackPressed() {
    // Check if there is a custom back button
    if (backButtonListener.isPresent()) {
        backButtonListener.get().run();
        backButtonListener = Optional.absent();
    } else {
        super.onBackPressed();
    }
}

@Override
public void setBackButtonListener(Optional<? extends Runnable> backButtonListener) {
    this.backButtonListener = backButtonListener;
}