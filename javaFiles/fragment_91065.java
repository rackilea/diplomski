public class Example {
    static public void main( String[] s ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.getContentPane().setLayout( new BorderLayout() );
                frame.setBounds( 50, 50, 600, 600 );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                final JButton button = new JButton( new AbstractAction("MyButton") {
                    @Override
                    public void actionPerformed( ActionEvent e ) {
                        System.out.println("Button Clicked");
                    }
                });
                frame.getContentPane().add( button );
                frame.getRootPane().setDefaultButton( button );

                KeyStroke f2 = KeyStroke.getKeyStroke("F2");
                frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f2, "clickButton");
                frame.getRootPane().getActionMap().put("clickButton", new AbstractAction() {
                    @Override
                    public void actionPerformed( ActionEvent e ) {
                        button.doClick();
                    }
                });
                frame.setVisible( true );
                // the Button has the focus
                button.requestFocus();
                // generate a KeyEvent 'F2' 
                KeyboardFocusManager.getCurrentKeyboardFocusManager().dispatchKeyEvent( new KeyEvent( frame, KeyEvent.KEY_PRESSED, 0, f2.getModifiers(), f2.getKeyCode(), f2.getKeyChar() ) );
            }
        });
    }
}