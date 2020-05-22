// in your task

@Override
protected Task<Image> createTask() {
    return new Task<Image>() {

        @Override
        protected Image call() {
            repaintImage();
            blackLinesCount++;
            return copyImage(image);
        }
    };
}