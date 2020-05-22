File file = new File("...");
try (ImageInputStream iis = ImageIO.createImageInputStream(file)) {
    Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
    if (readers.hasNext()) {
        ImageReader reader = readers.next();
        reader.addIIOReadProgressListener(new IIOReadProgressListener() {
            @Override
            public void sequenceStarted(ImageReader source, int minIndex) {
            }

            @Override
            public void sequenceComplete(ImageReader source) {
            }

            @Override
            public void imageStarted(ImageReader source, int imageIndex) {
            }

            @Override
            public void imageProgress(ImageReader source, float percentageDone) {
                //TODO: Update progress...
            }

            @Override
            public void imageComplete(ImageReader source) {
            }

            @Override
            public void thumbnailStarted(ImageReader source, int imageIndex, int thumbnailIndex) {
            }

            @Override
            public void thumbnailProgress(ImageReader source, float percentageDone) {
            }

            @Override
            public void thumbnailComplete(ImageReader source) {
            }

            @Override
            public void readAborted(ImageReader source) {
            }
        });
        reader.setInput(iis);
        try {
            BufferedImage img = reader.read(0);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
                Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("png");
                if (writers.hasNext()) {
                    ImageWriter writer = writers.next();
                    writer.addIIOWriteProgressListener(new IIOWriteProgressListener() {
                        @Override
                        public void imageStarted(ImageWriter source, int imageIndex) {
                        }

                        @Override
                        public void imageProgress(ImageWriter source, float percentageDone) {
                            // TODO: Update progress
                        }

                        @Override
                        public void imageComplete(ImageWriter source) {
                        }

                        @Override
                        public void thumbnailStarted(ImageWriter source, int imageIndex, int thumbnailIndex) {
                        }

                        @Override
                        public void thumbnailProgress(ImageWriter source, float percentageDone) {
                        }

                        @Override
                        public void thumbnailComplete(ImageWriter source) {
                        }

                        @Override
                        public void writeAborted(ImageWriter source) {
                        }
                    });

                    writer.setOutput(ios);
                    try {
                        writer.write(img);
                    } finally {
                        writer.removeAllIIOWriteProgressListeners();
                    }
                }
            }
        } finally {
            reader.removeAllIIOReadProgressListeners();
        }
    }
} catch (IOException exp) {
    exp.printStackTrace();
}