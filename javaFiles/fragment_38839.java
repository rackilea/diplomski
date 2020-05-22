public class FrameHotkey
{
    public static void main ( final String[] args )
    {
        SwingUtilities.invokeLater ( new Runnable ()
        {
            @Override
            public void run ()
            {
                final JFrame frame = new JFrame ();

                frame.setLayout ( new FlowLayout ( FlowLayout.CENTER, 15, 15 ) );
                frame.add ( new JLabel ( "Field 1:" ) );
                frame.add ( new JTextField ( "Field 1", 15 ) );
                frame.add ( new JLabel ( "Field 2:" ) );
                frame.add ( new JTextField ( "Field 2", 15 ) );

                // Hotkey for the F1 in window
                frame.getRootPane ().registerKeyboardAction ( new ActionListener ()
                {
                    @Override
                    public void actionPerformed ( final ActionEvent e )
                    {
                        JOptionPane.showMessageDialog ( frame, "F1 have been pressed!" );
                    }
                }, KeyStroke.getKeyStroke ( KeyEvent.VK_F1, 0 ), JComponent.WHEN_IN_FOCUSED_WINDOW );

                frame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
                frame.pack ();
                frame.setLocationRelativeTo ( null );
                frame.setVisible ( true );
            }
        } );
    }
}