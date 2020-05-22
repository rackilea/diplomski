private static final KeyStroke escapeStroke = 
    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0); 
public static final String dispatchWindowClosingActionMapKey = 
    "com.spodding.tackline.dispatch:WINDOW_CLOSING"; 
public static void installEscapeCloseOperation(final JDialog dialog) { 
    Action dispatchClosing = new AbstractAction() { 
        public void actionPerformed(ActionEvent event) { 
            dialog.dispatchEvent(new WindowEvent( 
                dialog, WindowEvent.WINDOW_CLOSING 
            )); 
        } 
    }; 
    JRootPane root = dialog.getRootPane(); 
    root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( 
        escapeStroke, dispatchWindowClosingActionMapKey 
    ); 
    root.getActionMap().put( dispatchWindowClosingActionMapKey, dispatchClosing 
    ); 
}