AttributedString text = new AttributedString(paragraph);

Font emphasis = new Font(Font.SERIF, Font.BOLD, 12);
int emphasisStart = 30;
int emphasisEnd = 42;
text.addAttribute(TextAttribute.FONT, emphasis, emphasisStart, emphasisEnd);

LineBreakMeasurer linebreaker =
    new LineBreakMeasurer(text.getIterator(), g.getFontRenderContext());