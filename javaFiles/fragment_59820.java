public void actionPerformed(ActionEvent e)
{
    Object source = e.getSource();
    if (source instanceof Component) {
        Component comp = (Component)source;
        gui.remove(comp.getParent());
        revalidate();
        repaint();
    }
}