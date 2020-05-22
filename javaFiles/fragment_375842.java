private static class ExampleListener implements ExampleTask.Listener {

    private final ImageView mImageView;

    private ExampleListener(ImageView imageView) {
        mImageView = imageView;
    }

    @Override
    public void onResult(Bitmap image) {
        mImageView.setImageBitmap(image);
    }
}

public void doSomething() {
   final ExampleListener listener = new ExampleListener(someImageView);
   new ExampleTask(listener).execute();
}