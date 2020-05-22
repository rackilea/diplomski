ActionListener queenClicker = new ActionListener()
{
    @Override
    public void actionPerformed(Action Event e)
    {
        JButton button = (JButton)e.getSource();
        button.setIcon( queen );
        //button.repaint(); // not needed the setIcon method will do the repaint()
    }
}