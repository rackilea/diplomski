public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {

            // 1. creating the frame window
            //
            MyFrame myFrame = new MyFrame();
            myFrame.add( P.g );
            P.g.setLayout( null );

            // others usefull  operations
            // configuring others objetcs
            // to be added on P.g

            // text[0] = new JTextArea(0, 0);
            // text[0].setLineWrap(true);
            // text[0].setEditable(false);
            // JScrollPane scroll = new JScrollPane(text[0]);
            // P.g.add(scroll);

            // 2. setting preferred size
            Dimension preferredSize = P.g.getPreferredSize();
            myFrame.setPreferredSize(preferredSize);

            // 3. need apply the pack method (here or any other place)
            // calling your method frame(JFrame)
            frame(myFrame);

            myFrame.setVisible( true );
            myFrame.pack();   

        }
    });

}