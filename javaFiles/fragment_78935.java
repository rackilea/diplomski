class CustomImageWorker extends ImgTagWorker {
    public CustomImageWorker(IElementNode element, ProcessorContext context) {
        super(element, context);
    }

    @Override
    public IPropertyContainer getElementResult() {
        return ((Image)super.getElementResult()).setAutoScale(true);
    }
}

ITagWorkerFactory customFactory = new DefaultTagWorkerFactory() {
    @Override
    public ITagWorker getCustomTagWorker(IElementNode tag, ProcessorContext context) {
        if (TagConstants.IMG.equals(tag.name())) {
            return new CustomImageWorker(tag, context);
        } else {
            return null;
        }
    }
};