public void eventOccurred(IEventData data, EventType type) {
        if (data instanceof TextRenderInfo) {
            super.eventOccurred(data, type);

        } else if (type == EventType.RENDER_PATH) {
            readRectangles((PathRenderInfo) data);
        } else if (type == EventType.RENDER_IMAGE) {
            readImage((ImageRenderInfo) data);
        }
    }