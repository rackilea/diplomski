class LeftPanel extends JPanel
{
    JButton exeButton;

    LeftPanel()
    {
        setLayout(null);
        setBounds(2, 42, 146, 252);

        button();
    }

    void button() 
    {       
        exebutton = new JButton("Execute");
        exebutton.setMnemonic(KeyEvent.VK_ENTER); // Shortcut: Alt + Enter
        exebutton.setBounds(4, 18, 138, 47);
        add(exebutton);
    }

    public JButton getDefaultBtn()
    {
        return exebutton;
    }
}