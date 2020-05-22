public class FaultCodesListCellRenderer extends Container implements ListCellRenderer {

Label focus;
Label code;
Label effect;
Image warning;
Image emergency;

public FaultCodesListCellRenderer(Resources res) {

    // get images for warning lights
    emergency = res.getImage("emergency.png");
    warning = res.getImage("warning.png");

    setLayout(new BorderLayout());
    setUIID("Underline");

    code = new Label();
    code.setUIID("BoldLabel");
    code.setTextPosition(RIGHT);
    code.getStyle().setMargin(Component.RIGHT, 6);

    effect = new Label();
    effect.setTickerEnabled(false);

    addComponent(BorderLayout.WEST, code);
    addComponent(BorderLayout.CENTER, effect);

    int h = Display.getInstance().convertToPixels(8, false);
    setPreferredH(code.getPreferredH() < h ? h : code.getPreferredH());

    focus = new Label("");
    focus.setUIID("UnderlineSelected");

}

public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {

    Diagnostic diagnostic = (Diagnostic) value;

    if (diagnostic.light.equals("R")) {
        code.setIcon(emergency);
    } else {
        code.setIcon(warning);
    }
    code.setText(diagnostic.code);
    effect.setText(diagnostic.effect);

    return this;
}

public Component getListFocusComponent(List list) {
    return focus;
}