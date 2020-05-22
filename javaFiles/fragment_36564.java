class FontRenderFilter extends RenderFilter {
    public boolean allowText(TextRenderInfo renderInfo) {
        String font = renderInfo.getFont().getPostscriptFontName();
        return font.endsWith("Bold") || font.endsWith("Oblique");
    }
}