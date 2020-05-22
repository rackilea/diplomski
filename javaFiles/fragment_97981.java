Map<byte[], String> extractAnnotationImages(PdfStream xObject) {
    final Map<byte[], String> result = new HashMap<>();
    IEventListener renderListener = new IEventListener() {
        @Override
        public Set<EventType> getSupportedEvents() {
            return Collections.singleton(RENDER_IMAGE);
        }

        @Override
        public void eventOccurred(IEventData data, EventType type) {
            if (data instanceof ImageRenderInfo) {
                ImageRenderInfo imageRenderInfo = (ImageRenderInfo) data;
                byte[] bytes = imageRenderInfo.getImage().getImageBytes();
                String extension = imageRenderInfo.getImage().identifyImageFileExtension();
                result.put(bytes, extension);
            }
        }
    };

    PdfCanvasProcessor processor = new PdfCanvasProcessor(renderListener, Collections.emptyMap());
    processor.processContent(xObject.getBytes(), new PdfResources(xObject.getAsDictionary(PdfName.Resources)));

    return result;
}