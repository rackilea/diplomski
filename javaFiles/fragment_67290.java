public List<Size> getSupportedVideoSizes() {
        if (params.getSupportedVideoSizes() != null) {
            return params.getSupportedVideoSizes();
        } else {
            // Video sizes may be null, which indicates that all the supported
            // preview sizes are supported for video recording.
            return params.getSupportedPreviewSizes();
        }
    }