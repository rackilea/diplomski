@Override
public IPropertyContainer getElementResult() {
    Image result = ((Image)super.getElementResult());
    if (!processed) {
        float imageWidth = result.getImageScaledWidth();
        float pageMargin = 36 * 2;
        float maxWidth = PageSize.A4.getWidth() - pageMargin;
        float maxHeight = PageSize.A4.getHeight() - pageMargin;
        if (imageWidth * 0.75 > maxWidth) {
            result.scaleToFit(maxWidth / 0.75f, maxHeight / 0.75f);
        }
        processed = true;
    }
    return result;
}