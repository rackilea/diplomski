public class A extends javax.swing.JFrame implements NativeKeyListener {

    public A() {
        initComponents();
    }

    //implement abstract methods  
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        a.getTA();
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        a.getTA();
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        a.getTA();
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(this);// add listner
        jTextArea1.append("logging started:\n");
    }

}