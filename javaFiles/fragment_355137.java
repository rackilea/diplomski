class MouseClickListener implements MouseListener
{
    public void mouseClicked (MouseEvent event)
    {
        Component comp = event.getComponent();
        if (comp instanceof JLabel) {
            ((JLabel)comp).setIcon(null);
        }
    }
}