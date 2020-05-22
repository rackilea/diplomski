//Constructor
public JSplash()
        {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setLayout (new BorderLayout());
            add(myButton, BorderLayout.SOUTH);
            setDefaultLookAndFeelDecorated(true);
            getContentPane().setBackground(bgColor);
            //adds action listener
            myButton.addActionListener(this);
            final int TALL = 316;
            final int WIDE = 304;
            setSize(WIDE, TALL);
            setVisible(true);
        }