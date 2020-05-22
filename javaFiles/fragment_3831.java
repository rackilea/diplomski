private static class CustomParagraphRenderer extends ParagraphRenderer {
    public CustomParagraphRenderer(Paragraph modelElement) {
        super(modelElement);
    }

    @Override
    public void drawChildren(DrawContext drawContext) {
        Random r = new Random();
        if (lines != null) {
            for (LineRenderer line : lines) {
                int leftMargin = r.nextInt(10);
                line.move(leftMargin, 0);
                line.draw(drawContext);
            }
        }
    }

    @Override
    public IRenderer getNextRenderer() {
        return new CustomParagraphRenderer((Paragraph) modelElement);
    }
}