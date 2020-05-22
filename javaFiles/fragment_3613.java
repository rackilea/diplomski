private static class LabelBlockTagWorkerFactory extends DefaultTagWorkerFactory {
    @Override
    public ITagWorker getCustomTagWorker(IElementNode tag, ProcessorContext context) {
        if (!TagConstants.LABEL.equals(tag.name())) {
            return null;
        }
        String display;
        if (tag.getStyles() == null || (display = tag.getStyles().get(CssConstants.DISPLAY)) == null) {
            return null;
        }
        if (CssConstants.BLOCK.equals(display)) {
            return new DivTagWorker(tag, context);
        }
        return null;
    }

}

private static class LabelBlockCssApplierFactory extends DefaultCssApplierFactory {
    @Override
    public ICssApplier getCustomCssApplier(IElementNode tag) {
        if (!TagConstants.LABEL.equals(tag.name())) {
            return null;
        }
        String display;
        if (tag.getStyles() == null || (display = tag.getStyles().get(CssConstants.DISPLAY)) == null) {
            return null;
        }
        if (CssConstants.BLOCK.equals(display)) {
            return new BlockCssApplier();
        }
        return null;
    }
}