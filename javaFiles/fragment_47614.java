private Bin createTextOverlayBin() {
    Bin textOverlayBin = new Bin();
    videoTypeOverlay = ElementFactory.make(TEXT_OVERLAY, "video-type-overlay");

    Optional<Pad> textOverlaySinkPad = playIdOverlay.getSinkPads().stream().filter(pad -> pad.getName().equals("video_sink")).findAny();
    Optional<Pad> textOverlaySrcPad = videoTypeOverlay.getSrcPads().stream().filter(pad -> pad.getName().equals("src")).findAny();

    if (textOverlaySinkPad.isPresent() && textOverlaySrcPad.isPresent()) {
        textOverlayBin.add(playIdOverlay);
        textOverlayBin.add(videoTypeOverlay);

        GhostPad ghostSinkPad = new GhostPad("sink", textOverlaySinkPad.get());
        textOverlayBin.addPad(ghostSinkPad);

        GhostPad ghostSrcPad = new GhostPad("src", textOverlaySrcPad.get());
        textOverlayBin.addPad(ghostSrcPad);


        playIdOverlay.link(videoTypeOverlay);
    } else {
        LOGGER.error("Video text overlay element creation is failed!");
    }
    return textOverlayBin;
}