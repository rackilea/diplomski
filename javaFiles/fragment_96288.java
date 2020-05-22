SwingWorker<Void, Mat> worker = new SwingWorker<Void, Mat>() {
    @Override
    protected Void doInBackground() throws Exception {            
        while(!isCancelled()) {
            if (camera.read(iframe)) {
                publish(iframe);
            }
            Thread.sleep(500); // prudential time to avoid block the event queue
        }            
        return null;
    }

    @Override
    protected void process(List<Mat> chunks) {
        Mat lastFrame = chuncks.get(chunks.size() - 1);
        Highgui.imwrite(canvas, lastFrame);
    }        
};

worker.execute();