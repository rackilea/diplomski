public class AlwaysDefaultAquaButtonBorder extends AquaButtonBorder.Dynamic {

    @Override
    protected JRSUIConstants.Widget getStyleForSize(final AbstractButton b, 
                                                final JRSUIConstants.Size size,
                                                final int width, 
                                                final int height) {
        if(b != null && b.getRootPane() != null 
            && Objects.equals(b, b.getRootPane().getDefaultButton())) {
            return JRSUIConstants.Widget.BUTTON_PUSH;
        }
        return super.getStyleForSize(b, size, width, height);
    }

}