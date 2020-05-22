protected JMenu createStyleMenu() {
    JMenu menu = new JMenu("Style");

    Action action = new StyledEditorKit.AlignmentAction(
        "left-justify", StyleConstants.ALIGN_LEFT);
    action.putValue(Action.NAME, "Left");
    menu.add(action);
    menu.addSeparator();
    ...
}