public void actionPerformed(ActionEvent e)
{
    Container contentPane = getContentPane();

    if (!on) {
            contentPane.setBackground(Color.YELLOW);
            on = true;
    }
    else  {
        contentPane.setBackground(Color.DARK_GRAY);
        on = false;
    }
}