class MyFrame extends JFrame
{
    MyFrame()
    {
        setLayout(new GridLayout(3,4));

        for (int i = 0; i < 9; ++i)
            this.getContentPane().add(new JLabel(""+i));
        for (int i = 0; i < 3; ++i)
            getContentPane().add(new JLabel());

        pack();
        setVisible(true);
    }
}