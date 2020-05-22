void play(ImageView im, AtomicReference<Bounds> bounds, String Url){
    new Thread(() -> {
        frameGrabber = new FFmpegFrameGrabber(Url);
        frameGrabber.setVideoOption("preset","ultrafast");
        frameGrabber.setOption("rtsp_transport","tcp");
        frameGrabber.setOption("stimeout" , "60000");
        frameGrabber.setAudioChannels(0);
        frameGrabber.setAudioCodec(0);
        try {
            frameGrabber.start();
            start=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        JavaFXFrameConverter jconverter=new JavaFXFrameConverter();

        AtomicReference<Image> imageHolder = new AtomicReference<>(null);
        while(true){
            Frame frame = frameGrabber.grabImage();

            Bounds imgBounds = bounds.get();
            double width = imgBounds.getWidth();
            double height = imgBounds.getHeight();

            // resize frame to width, height....

            Image image=jconverter.convert(frame);

            if (imageHolder.getAndSet(image) == null) {
                Platform.runLater(() -> im.setImage(imageHolder.getAndSet(null)));
            }
        }
    }).start();  
}