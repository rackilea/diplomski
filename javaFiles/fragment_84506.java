private static class MediaResizer extends MediaToolAdapter {
    private IVideoResampler videoResampler = null;
    private int mediaHeight;
    private int mediaWidth;

    public MediaResizer (int aHight, int aWidth) {
        mediaWidth = aWidth;
        mediaHeight = aHeight;
    }

    @Override
    public void onVideoPicture(IVideoPictureEvent event) {
        // In case of audio only, do not re-size as it is not needed
        if(job.role == MediaRole.MediaRoleEnum.LS_AUDIO) super.onVideoPicture(event);

        IVideoPicture pic = event.getPicture();

        if (videoResampler == null) {
            videoResampler = IVideoResampler.make(job.getCoderSettings().width, job.getCoderSettings().height, pic.getPixelType(), pic.getWidth(), pic.getHeight(), pic.getPixelType());
        }

        IVideoPicture out = IVideoPicture.make(pic.getPixelType(), mediaWidth, mediaHeight);
        videoResampler.resample(out, pic);

        IVideoPictureEvent asc = new VideoPictureEvent(event.getSource(), out, event.getStreamIndex());
        super.onVideoPicture(asc);

        out.delete();
    }

}