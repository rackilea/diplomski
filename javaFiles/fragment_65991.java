public class SVGCanvas extends JSVGCanvas {

    private static final long serialVersionUID = 1L;

    /**
     * The type of scale
     */
    private short svgScale;

    /**
     * Image padding
     */
    private int svgPadding;

    public SVGCanvas() {
        this.svgScale = SVGPreserveAspectRatio.SVG_PRESERVEASPECTRATIO_XMIDYMAX;
        this.svgPadding = 5;
    }

    @Override
    protected AffineTransform calculateViewingTransform(String svgElementIdentifier, SVGSVGElement svgElement) {
        SVGRect svgElementBounds = svgElement.getBBox();
        float[] svgElementBoundsVector = new float[] {
            svgElementBounds.getX(),
            svgElementBounds.getY(),
            svgElementBounds.getWidth(),
            svgElementBounds.getHeight()
        };

        float svgEemenetScaleToHeight = getHeight() - svgPadding;
        float svgElementScaleToWidth = getWidth() - svgPadding;

        return ViewBox.getPreserveAspectRatioTransform(
            svgElementBoundsVector, svgScale, true,
            svgElementScaleToWidth,
            svgEemenetScaleToHeight
        );
    }

    public void setSvgScale(short svgScale) {
        this.svgScale = svgScale;
    }

    public void setSvgPadding(int svgPadding) {
        this.svgPadding = svgPadding;
    }

}