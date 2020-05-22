SwingWorker tmp = new SwingWorker<ImageIcon[], Object>() {
    public ImageIcon[] doInBackground() {
            final ImageIcon[] innerImgs = new ImageIcon[nimgs];
        ...//Load all the images...
        return imgs;
    }
    public void done() {
        //Remove the "Loading images" label.
        animator.removeAll();
        loopslot = -1;
        try {
            imgs = get();
        } ...//Handle possible exceptions
    }

};