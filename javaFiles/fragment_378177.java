LookAndFeel laf = null;
try {
    String lafClassName = UIManager.getSystemLookAndFeelClassName();
    laf = (LookAndFeel) (Class.forName(lafClassName).newInstance());
} catch (ClassNotFoundException ex) {
} catch (InstantiationException ex) {
} catch (IllegalAccessException ex) {
}
if (laf != null) {
    laf.initialize();
    button.setUI((ButtonUI) laf.getDefaults().getUI(button));
}