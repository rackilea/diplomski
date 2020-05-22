preview.setOnPreviewOutputUpdateListener(new Preview.OnPreviewOutputUpdateListener() {
        @Override
        public void onUpdated(Preview.PreviewOutput output) {
             ...
             Size resolution = output.getTextureSize();
             ...
        }
    });